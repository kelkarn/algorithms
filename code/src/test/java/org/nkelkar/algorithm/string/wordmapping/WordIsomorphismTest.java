package org.nkelkar.algorithm.string.wordmapping;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: dell
 * Date: 2/9/14
 * Time: 1:25 PM
 */
public class WordIsomorphismTest {

    @Test
    public void testWordIsomorphism() {
        Assert.assertTrue(WordIsomorphism.areIsomorphic("turtle", "tletur"));
        Assert.assertTrue(WordIsomorphism.areIsomorphic("foo", "app"));
        Assert.assertFalse(WordIsomorphism.areIsomorphic("foo", "bar"));
    }
}
