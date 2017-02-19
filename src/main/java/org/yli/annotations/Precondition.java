package org.yli.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yli on 2/18/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Precondition {
  /**
   * Get the array of non-null arguments
   * @return the array of arguments.
   */
  String[] nonNullArgs();
}
