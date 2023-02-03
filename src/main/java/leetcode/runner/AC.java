package leetcode.runner;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AC {
    // 算法时间占用情况，默认单位为ms
    String time() default "";
    // 算法内存占用情况，默认单位为MB
    String memory() default "";
    // 时间占用排名
    String timeRank() default "";
    // 内存占用排名
    String memoryRank() default "";
}
