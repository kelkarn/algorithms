package org.nkelkar.algorithm.stringencoding;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

/**
 * User: dell
 * Date: 1/12/14
 * Time: 1:04 PM
 */
public class EncodeString {

    public static char[] encode(char[] s) {

        if(s == null || s.length == 0)
            return null;

        int curr = 1;
        int toModify = 0;
        int cnt = 1;
        char memChar = s[curr];
        //curr = 1;   // start off

        while(curr <= s.length) {
            if(curr < s.length)
                if(s[curr] == memChar) { // same char so far
                    cnt++;
                }
            if((curr == s.length) || (s[curr] != memChar)) {  // change of char - will have to encode
                                                              // uses lazy evaluation!
                s[toModify] = memChar;
                toModify = toModify + 1;    // increment for writing #times this char occurred
                int numDigits = getNumDigits(cnt);

                if(curr < s.length)
                    memChar = s[curr];   // switch memChar to be newly found char

                int tempCnt = cnt;
                int tempNumDigits = numDigits;
                // write the actual digits
                while(tempNumDigits > 0) {
                    s[toModify + tempNumDigits - 1] = (char)(tempCnt%10 + '0');
                    tempCnt = tempCnt/10;
                    tempNumDigits--;
                }
                // reset counter for next character
                // also reset toModify to point to next available character
                cnt = 1;    // reset
                toModify = toModify + numDigits;
            }
            curr++;
        }
        return Arrays.copyOfRange(s, 0, toModify);
    }

    private static int getNumDigits(int count) {

        int numDigits = 0;
        // count the digits to write
        while(count != 0) {
            numDigits++;
            count = count/10;
        }
        return numDigits;
    }
}