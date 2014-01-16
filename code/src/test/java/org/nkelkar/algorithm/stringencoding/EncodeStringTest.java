package org.nkelkar.algorithm.stringencoding;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: dell
 * Date: 1/12/14
 * Time: 4:25 PM
 */
public class EncodeStringTest {

    @Test
    public void testStringEncoding() {
        char[] input = new char[] {'a', 'a', 'b', 'c', 'c', 'c', 'c'};

        // test case when input.length is odd
        Assert.assertArrayEquals("failure - string not encoded correctly",
                                 new char[] {'a', '2', 'b', '1', 'c', '4'}, EncodeString.encode(input));

        // test case when input.length is even
        input = new char[] {'a', 'a', 'b', 'd', 'd', 'c', 'c', 'c'};

        Assert.assertArrayEquals("failure - string not encoded correctly",
                                 new char[] {'a', '2', 'b', '1', 'd', '2', 'c', '3'}, EncodeString.encode(input));

        // test case when null is passed
        Assert.assertNull("failure - encoding function did not return null on being passed a null", EncodeString.encode(null));
    }
}
