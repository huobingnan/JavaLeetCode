package leetcode.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Outline {
    String name() default "";
    ProblemLevel level() default ProblemLevel.UNKNOWN;
    String description() default "";
}
