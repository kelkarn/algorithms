package org.nkelkar.algorithm.string.missingnumber;

/**
 * User: dell
 * Date: 2/8/14
 * Time: 7:23 PM
 */
public class MissingFromSequence {

    public static int getMissingNumber(String sequence) {
        int length = sequence.length();

        // for each order of number, check whether
        // this is a valid sequence with a missing
        // number

        // initialize variables you may need in the
        // loops to follow
        int candidate = -1;
        boolean isIncreasingSeq;
        int prev;
        int k;  // duplicate of i to account for change in #digits
        int newDigitStart;
        for(int i=1; i<length/2; i++) {
            isIncreasingSeq  = true;
            prev = Integer.parseInt(sequence.substring(0, i));
            k = i;
            newDigitStart = i;

            // loop over each character in the string
            // when the diff (j - newDigitStart)%k == 0
            // then stop for a while, and perform checks
            // then, reset newDigitStart = j
            for(int j=i; j<=length; j++) {
                if(((j - newDigitStart)%k == 0) && ((j - newDigitStart) != 0)) {
                    int curr = Integer.parseInt(sequence.substring(newDigitStart, j));
                    // three cases: (current num - prev num) = 1
                    // or (current num - prev num) = 2
                    // or (current num - prev num) some other number
                    if((curr - prev) == 1) {
                       prev = curr;
                       newDigitStart = j;
                    }
                    else if((curr - prev) == 2) {
                        candidate = prev + 1;
                        prev = curr;
                        newDigitStart = j;
                    }
                    else {  // two cases here: this may be a #digit change
                            // or the sequence genuinely ends here
                            // check for both
                        if(j != length) {
                            curr = Integer.parseInt(sequence.substring(newDigitStart, j+1));
                            if((curr - prev) == 1) {
                                // first, change k
                                k = k + 1;  // num digits have changed
                                prev = curr;
                            }
                            else if((curr - prev) == 2) {
                                candidate = prev + 1;
                                prev = curr;
                            }
                            else {
                                isIncreasingSeq = false;
                                break;
                            }
                        }
                        else {
                            isIncreasingSeq = false;
                            break;
                        }
                        newDigitStart = j+1;
                    }
                }
            }

            if(isIncreasingSeq) {
                break;
            }
        }

        return candidate;
    }
}
