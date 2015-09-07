/**
* @author DuanSky
* @date 2015年9月7日 下午9:58:50
* @content 
*/
package com.sky.learningJava.annotation.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
	public String name() default "";
}
