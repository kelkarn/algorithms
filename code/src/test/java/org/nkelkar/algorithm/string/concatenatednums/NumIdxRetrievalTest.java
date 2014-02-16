package org.nkelkar.algorithm.string.concatenatednums;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: dell
 * Date: 2/8/14
 * Time: 6:50 PM
 */
public class NumIdxRetrievalTest {

    @Test
    public void testNumIdxRetrieval() {
        Assert.assertEquals(NumIdxRetrieval.getNumIdx(25, 20), 29);
    }
}
