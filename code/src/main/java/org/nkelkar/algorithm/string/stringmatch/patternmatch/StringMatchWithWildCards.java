package org.nkelkar.algorithm.string.stringmatch.patternmatch;

/**
 * User: dell
 * Date: 2/13/14
 * Time: 12:00 PM
 */
public class StringMatchWithWildCards {

    public static boolean matchStrings(String text, String pattern) {

        int lengthText = text.length();
        int lengthPattern = pattern.length();
        int i = 0;
        int j = 0;

        while(i < lengthText) {
            if(j == lengthPattern)  // pattern can never be longer
                return false;       // than the original text

            if(text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
                j = j + 1;
            }
            else if (pattern.charAt(j) == '*') {
                // here, we need to count instances
                // in text, that correspond to this
                // character.
                if(text.substring(i, text.length()).equals(pattern.substring(j+1, pattern.length())))
                    return matchStrings(text.substring(i), pattern.substring(j+1)); // '*' may represent
                                                                                  // no characters at all
                char currTextChar = text.charAt(i);
                char prevPatternChar = pattern.charAt(j-1);
                if(currTextChar != prevPatternChar) {   // this means the '*'
                                                        // denotes no character
                    i = i - 1;  // restore i to current position
                    j = j + 1;  // after it's re-increment by 1
                }
                else {
                    // fast forward i to point to character
                    // where (currTextChar != prevPatternChar)
                    while(i < lengthText && currTextChar == prevPatternChar) {
                        currTextChar = text.charAt(i);
                        i = i + 1;
                    }

                    if(i == lengthText) {// text reached end first
                        return (j == lengthPattern - 1);
                    }
                    else {
                        i = i - 1; // same as above. ready for
                        j = j + 1; // next piece of string matching
                    }
                }
            }
            else return false;

            i = i + 1;
        }


        return (i == lengthText && j == lengthPattern);
    }
}
