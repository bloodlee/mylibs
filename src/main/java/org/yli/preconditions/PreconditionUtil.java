package org.yli.preconditions;

/**
 * Created by yli on 2/18/2017.
 */
public class PreconditionUtil {

  /**
   * Check if there is any null arguments
   * @param givenArguments array of given arguments.
   * @return true or false.
   */
  public static boolean anyNull(Object... givenArguments) {
    if (givenArguments == null || givenArguments.length == 0) {
      return false;
    }

    for (Object arg : givenArguments) {
      if (arg == null) {
        return true;
      }
    }

    return false;
  }

}
