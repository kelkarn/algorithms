package org.nkelkar.algorithm.linkedlist.sorting;

import org.junit.Test;

/**
 * User: dell
 * Date: 1/26/14
 * Time: 8:08 PM
 */
public class MergeSortedLLTest {

    @Test
    public void testMergeSortedLL() {
        MergeSortedLL<Integer> myLinkedList = new MergeSortedLL<Integer>(new Integer[] {3, 5, 7, 11, 14, 15, 9});
        myLinkedList.mergeSortList();   // sort
        myLinkedList.printList();
    }
}
