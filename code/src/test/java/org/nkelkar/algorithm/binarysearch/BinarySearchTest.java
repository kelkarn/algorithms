package org.nkelkar.algorithm.binarysearch;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: dell
 * Date: 1/12/14
 * Time: 4:26 AM
 */
public class BinarySearchTest {

    @Test
    public void testBinarySearch() {

        Double[] arrayToTest = new Double[] {1.0, 3.0, 15.0, 44.0, 62.0, 93.0, 123.0};

        // test case when element not in array
        Assert.assertEquals("failure - binary search failed to find " + 1000, -1, BinarySearch.search(arrayToTest, 1000));

        // test case when element in right half of array
        Assert.assertEquals("failure - binary search failed to find " + 123, 6, BinarySearch.search(arrayToTest, 123));

        // test case when element in left half of array
        Assert.assertEquals("failure - binary search failed to find " + 3, 1, BinarySearch.search(arrayToTest, 3));
    }
}
