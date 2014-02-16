package org.nkelkar.algorithm.string.wordmapping;

import java.util.*;

/**
 * User: dell
 * Date: 2/9/14
 * Time: 12:46 PM
 */
public class WordIsomorphism {

    public static boolean areIsomorphic(String s1, String s2) {

        // first go through first word, and then
        // note all positions of each distinct character
        Map<Character, Set<Integer>> s1letterMapping = new HashMap<Character, Set<Integer>>();
        Map<Character, Set<Integer>> s2letterMapping = new HashMap<Character, Set<Integer>>();

        // now iterate over s1 and populate above map
        char currChar;
        for(int i=0; i<s1.length(); i++) {
            currChar = s1.charAt( i );
            Set<Integer> positions = s1letterMapping.get( currChar );
            if(positions == null) {
                positions = new HashSet<Integer>();
                positions.add( i );
                s1letterMapping.put( currChar, positions);
            }
            else {
                positions.add( i );
                s1letterMapping.put( currChar, positions);
            }
        }

        // now populate a set of ArrayLists
        Set<Set<Integer>> s1Positions = new HashSet<Set<Integer>>();

        for (Set<Integer> v : s1letterMapping.values()) {
            s1Positions.add( v );
        }

        // now map the second string s2 and store it's positions
        for(int j=0; j<s2.length(); j++) {
            currChar = s2.charAt( j );
            Set<Integer> positions = s2letterMapping.get( currChar );
            if(positions == null) {
                positions = new HashSet<Integer>();
                positions.add( j );
                s2letterMapping.put( currChar, positions);
            }
            else {
                positions.add( j );
                s2letterMapping.put( currChar, positions);
            }
        }

        Set<Set<Integer>> s2Positions = new HashSet<Set<Integer>>();

        for (Set<Integer> v : s2letterMapping.values()) {
            s2Positions.add( v );
        }

        // now iterate over one set, and see if it contains
        // sets of positions from the other positions set
        // if yes, remove from the other set, and iterate
        if(s1Positions.size() != s2Positions.size())
            return false;

        for (Set<Integer> s1Pos : s1Positions) {
            if (s2Positions.contains(s1Pos)) {
                s2Positions.remove(s1Pos);
            } else return false;
        }
        return true;
    }
}
