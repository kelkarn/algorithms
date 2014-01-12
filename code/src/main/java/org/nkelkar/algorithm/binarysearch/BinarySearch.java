package org.nkelkar.algorithm.binarysearch;

/**
 * User: dell
 * Date: 1/12/14
 * Time: 3:43 AM
 */
public class BinarySearch {

    public static int search(Double[] A, double target) {

        if (A.length == 0) return -1;

        int p = 0;  // start index
        int q = A.length - 1;

        int mid = (int) Math.ceil(((double)(q - p + 1))/2) - 1;

        while (p <= q) {
            if(A[p + mid] > target)
                q = q - mid - 1;    // lower the bar on upper limit
            else if(A[p + mid] < target)
                p = p + mid + 1;    // up the bar on lower limit
            else
                return p+mid; // match found! return the index
            mid = (int) Math.ceil(((double)(q - p + 1))/2) - 1;
        }

        return -1;  // no match found in input array
    }
}
