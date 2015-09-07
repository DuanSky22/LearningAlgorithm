package com.sky.learningJava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * 注解很像接口。会被编译成一个单独的class文件。
 * target/retention/documented/inherited是四种元注解。
 * target表明该注解作用在什么类型上（方法？包？参数？构造器？局部变量？。。。）
 * retention表明该注解作用在什么时候（运行时？源代码级别？class文件级别？）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	public int id() default -1;
	public String description() default "no description";
}
