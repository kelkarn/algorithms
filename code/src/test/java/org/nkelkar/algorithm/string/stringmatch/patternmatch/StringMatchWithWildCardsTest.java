package org.nkelkar.algorithm.string.stringmatch.patternmatch;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: dell
 * Date: 2/13/14
 * Time: 12:22 PM
 */
public class StringMatchWithWildCardsTest {

    @Test
    public void testMatchStrings() {
        Assert.assertFalse(StringMatchWithWildCards.matchStrings("Facebook", "F*cebo.k"));
        Assert.assertTrue(StringMatchWithWildCards.matchStrings("Facebook", "F.cebo.k"));
        Assert.assertTrue(StringMatchWithWildCards.matchStrings("Facebooo", "Facebo*"));
        Assert.assertFalse(StringMatchWithWildCards.matchStrings("Facebooker", "F.cebo*"));
        Assert.assertTrue(StringMatchWithWildCards.matchStrings("Facebook", "Facebo*ok"));
    }
}
