package org.tdd;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author wangzhi
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Option {

    String value();

}
