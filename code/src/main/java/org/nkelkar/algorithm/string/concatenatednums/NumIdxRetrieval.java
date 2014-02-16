package org.nkelkar.algorithm.string.concatenatednums;

/**
 * User: dell
 * Date: 2/8/14
 * Time: 6:19 PM
 */
public class NumIdxRetrieval {

    public static int getNumIdx(Integer maxNum, Integer target) {

        if(target > maxNum)
            throw new IllegalArgumentException("the target number should be less than maximum allowed.");

        int ret = 0;
        int targetCopy = target;
        int numDigits = 0;

        while(targetCopy != 0) {
            targetCopy = targetCopy/10;
            numDigits++;
        }

        int factor = 1;
        for(int i=1; i<numDigits; i++) {
            ret = ret + i*9*factor;
            factor = factor*10;
        }

        ret = ret + (target - factor)*numDigits;

        return ret;
    }
}
