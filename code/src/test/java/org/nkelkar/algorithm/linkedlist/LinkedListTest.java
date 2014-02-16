package org.nkelkar.algorithm.linkedlist;

import org.junit.Test;
import org.nkelkar.algorithm.linkedlist.sorting.util.Element;

/**
 * User: dell
 * Date: 1/26/14
 * Time: 9:36 PM
 */
public class LinkedListTest {

    @Test
    public void testLinkedList() {
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>(new Integer[] {2, 3, 5, 7, 11, 13});

        //Element<Integer> myInt = myLinkedList.get(1);
        //myLinkedList.delete( myInt );
        //System.out.println("integer: " + myInt);
        /*
        LinkedList<Integer> number1 = new LinkedList<Integer>(new Integer[] {9, 0});
        LinkedList<Integer> number2 = new LinkedList<Integer>(new Integer[] {9}); // so sum should be 908

        LinkedList<Integer> results = LinkedList.addLists(number1, number2);

        results.reverseList();
        results.printList();
        */
        myLinkedList.reverseEveryK(3);
        myLinkedList.printList();
    }
}
