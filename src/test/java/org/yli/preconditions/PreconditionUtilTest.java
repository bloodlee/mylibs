package org.yli.preconditions;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yli on 2/18/2017.
 */
public class PreconditionUtilTest {

  @Test
  public void testAnyNull() {
    assertFalse(PreconditionUtil.anyNull());
    assertFalse(PreconditionUtil.anyNull(1, 2.0, 3L, "hello"));
    assertTrue(PreconditionUtil.anyNull(null, 1, "hello"));
    assertTrue(PreconditionUtil.anyNull(new Object[] {1, 2.0, "hello", null}));
  }

}
