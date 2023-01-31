package leetcode.runner;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.InputStream;
import java.lang.reflect.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LeetCodeCaseRunner {

    @Data
    public static class Config {
        public static final String PARAMETER = "PARAMETER";
        public static final String RETURN    = "RETURN";
        public static final String PRINT     = "PRINT";

        private Boolean debugMode = false;
        private String checkMode = RETURN;
        private Integer checkIndex = 0;
    }

    private static JSONObject loadTestCaseJsonFile(Class<?> entryClass) {
        final String className = entryClass.getSimpleName();
        final String caseFileName = String.format("%s.json", className);
        URL fileUrl = entryClass.getClassLoader().getResource(caseFileName);
        if (fileUrl == null) {
            throw new RuntimeException("Can't load the test case file named " + className + ".json");
        }
        return JSON.parseObject(fileUrl);
    }

    private static Object newEntryClassInstance(Class<?> entryClass) {
        final Constructor<?> constructor = entryClass.getConstructors()[0];
        try {
            return constructor.newInstance(null);
        }catch (Exception ex) {
            throw new RuntimeException("The entry class named " + entryClass.getSimpleName()
                    + " must have a empty parameter constructor");
        }
    }

    private static Method getProxyMethod(Class<?> entryClass) {
        final Method[] allMethods = entryClass.getDeclaredMethods();
        final Method proxyMethod = Arrays.stream(allMethods)
                .filter(method -> method.getAnnotation(LeetCodeTest.class) != null)
                .findFirst().get();
        if (proxyMethod == null) {
            throw new RuntimeException("Can't find the test method");
        }
        return proxyMethod;
    }


    private static void runTestCase(Config config, JSONObject caseObject, Object instance, Method method) {
        // debugMode
        if (config.debugMode) {
            final Boolean debugOn = caseObject.getBoolean("debug");
            if (debugOn == null || debugOn == Boolean.FALSE) return;
        }

        final JSONArray input = caseObject.getJSONArray("input");
        if (input == null) {
            throw new RuntimeException("Error json format: can't find the input case field");
        }
        // prepare method parameters
        final Object[] args = new Object[method.getParameterCount()];
        final Parameter[] parameters = method.getParameters();
        if (parameters.length != input.size()) {
            throw new RuntimeException("Method parameters mismatch");
        }
        for (int i = 0; i < parameters.length; i++) {
            args[i] = input.getObject(i, parameters[i].getType());
        }

        Object result = null; Object expect = null;
        try {
            result = method.invoke(instance, args);
        }catch (Exception ex) {
            throw new RuntimeException("Method invocation error: " + ex.getMessage());
        }

        final String checkMode = config.checkMode.toUpperCase();
        if (Config.PARAMETER.equals(checkMode)) {
            result = args[config.checkIndex];
        }
        expect = caseObject.getObject("expect", result.getClass());
        if (expect == null) {
            throw new RuntimeException("Error json format: expect field missing or type mismatch");
        }
        // print the digest
        System.out.println("    Input  :" + prettyToString(input));
        System.out.println("    Output :" + prettyToString(result));
        System.out.println("    Expect :" + prettyToString(expect));
        // result check
        if (Config.PRINT.equals(checkMode)) return;
        final boolean equal = resultCompare(result, expect);
        if (equal) {
            System.out.println("PASS ^_^");
        } else {
            System.out.println("FAIL !!!");
        }

    }

    private static boolean resultCompare(Object result, Object expect) {
        boolean compare = true;
        final Class resultClazz = result.getClass();
        final Class expectClazz = expect.getClass();
        if (!resultClazz.equals(expectClazz))
            throw new RuntimeException("The type of result and output are not equal");
        if (resultClazz.isArray()) {
            final Class resultComponentType = resultClazz.getComponentType();
            final Class expectComponentType = expectClazz.getComponentType();
            if (!resultComponentType.equals(expectComponentType))
                throw new RuntimeException("Element type mismatch");
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                final Object a = Array.get(result, i);
                final Object b = Array.get(expect, i);
                if (resultComponentType.isArray()) { compare = resultCompare(a, b);}
                else {
                    if (!a.equals(b)) {
                        compare = false;
                        break;
                    }
                }
            }
        } else {
            compare = Objects.equals(result, expect);
        }
        return compare;
    }

    private static String prettyToString(Object obj) {
        if (obj == null) return "NULL";
        final Class clazz = obj.getClass();
        if (clazz.isArray()) {
            final int length = Array.getLength(obj);
            final StringJoiner sj = new StringJoiner(",", "[", "]");
            for (int i = 0; i < length; i++) {
                final Object cur = Array.get(obj, i);
                if (cur.getClass().isArray()) {
                    sj.add(prettyToString(cur));
                } else {
                    sj.add(cur.toString());
                }
            }
            return sj.toString();
        } else {
            return obj.toString();
        }
    }


    public static void run(Class<?> entryClass) {
        final JSONObject testCaseDefinitionObject = loadTestCaseJsonFile(entryClass);
        final Object instance = newEntryClassInstance(entryClass);
        final Method proxyMethod = getProxyMethod(entryClass);
        final Set<String> keys = testCaseDefinitionObject.keySet();

        Config config = testCaseDefinitionObject.getObject("config", Config.class);
        if (config == null) config = new Config();
        final Config capturedConfig = config;

        keys.stream()
                .filter(key -> key.startsWith("#"))
                .map(testCaseDefinitionObject::getJSONObject)
                .forEach(testCase -> runTestCase(capturedConfig, testCase, instance, proxyMethod) );
    }
}
