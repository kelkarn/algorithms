package org.nkelkar.algorithm.linkedlist.sorting;

import org.nkelkar.algorithm.linkedlist.sorting.util.Element;

import java.util.LinkedList;

/**
 * User: dell
 * Date: 1/26/14
 * Time: 1:41 PM
 */
public class MergeSortedLL<T extends Comparable<? super T>> {

    private Element<T> head;

    public MergeSortedLL(T[] data) {
        head = new Element<T>(data[0]);
        Element<T> linker = head;
        //System.out.println("length of input: " + data.length);

        for(int i=1; i<data.length; i++) {
            linker.setNext(new Element<T>(data[i]));    // create list
            linker = linker.getNext();  // move forward
            //System.out.println(linker.toString() + "|");
        }
        //printList();
        checkLL();
    }

    public MergeSortedLL(LinkedList<T> data) {
        head = new Element<T>(data.getFirst());
        Element<T> linker = head; // set initial reference to head

        for(int i=0; i<data.size(); i++)
            linker.setNext(new Element<T>(data.get( i )));

        checkLL();
    }

    private void checkLL() {
        Element<T> prev = head;
        Element<T> curr = prev;


        while(curr.hasNext()) {
            curr = curr.getNext();
            if(curr.compareTo(prev) < 0) {
                break;  // next sorted list started
            }
            prev = curr;
        }

        if(curr.compareTo(prev) > 0)    // the list just ended
            throw new IllegalArgumentException("Input list is supposed to have exactly two sorted sub-lists of numbers. " +
                                               "Found only one sub-list of sorted numbers.");

        prev = curr;    // store this position for checking next part of list

        while(curr.hasNext()) {
            curr = curr.getNext();
            if(curr.compareTo(prev) < 0) {
                // this was not supposed to happen. So throw exception
                throw new IllegalArgumentException("Input list is supposed to have only two sorted set of numbers. " +
                                                   "Found discrepancy between " + prev + " and " + curr);
            }
            prev = curr;
        }
    }

    public void mergeSortList() {
        Element<T> firstListIterator = head;
        Element<T> secondListIterator = head;
        Element<T> temp = head; // create temp pointer to store
                                // a reference temporarily
        while(temp.compareTo(temp.getNext()) < 0)
            temp = temp.getNext();
        // now set the head of second list and temp's next to null

        secondListIterator = temp.getNext();
        temp.setNext( null );

        do {
            if(firstListIterator.compareTo(secondListIterator) > 0) {// second list elem is greater than first list elem
                temp = secondListIterator.getNext();
                secondListIterator.setNext(firstListIterator);
                head = secondListIterator;  // rewind head
                secondListIterator = temp;  // reset second list's iterator
                firstListIterator = head;   // rewind this as well
            }
            else if(firstListIterator.compareTo(secondListIterator) <= 0 &&  // in between case
                    firstListIterator.getNext().compareTo(secondListIterator) >= 0) {
                temp = firstListIterator.getNext();
                firstListIterator.setNext(secondListIterator);
                Element<T> temp2 = secondListIterator.getNext();    // to store next pointer of second list
                firstListIterator.getNext().setNext(temp);
                secondListIterator = temp2; // reset back
                firstListIterator = firstListIterator.getNext();    // move forward
            }
            else {
                firstListIterator = firstListIterator.getNext();
            }

        }while((firstListIterator.getNext() != null) && (secondListIterator != null));

        if(firstListIterator.getNext() == null) {// if first list ended early
            //temp = head;
            //while(temp.getNext() != null)
            //    temp = temp.getNext();
            firstListIterator.setNext( secondListIterator ); // link the remaining part of second list
        }
    }

    public void printList() {
        Element<T> iterator = head;
        while(iterator != null) {
            System.out.println(iterator.toString() + "|");
            iterator = iterator.getNext();
        }
    }

}
