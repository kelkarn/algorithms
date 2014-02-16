package org.nkelkar.algorithm.linkedlist;

import org.nkelkar.algorithm.linkedlist.sorting.util.Element;

/**
 * User: dell
 * Date: 1/26/14
 * Time: 9:22 PM
 */
public class LinkedList<T extends Comparable<? super T>> {

    private Element<T> head;
    private Long length;    // to store length of list

    public  LinkedList() {
        head = new Element<T>();
    }

    public LinkedList(T[] data) {
        head = new Element<T>(data[0]);
        Element<T> linker = head;
        //System.out.println("length of input: " + data.length);

        for(int i=1; i<data.length; i++) {
            linker.setNext(new Element<T>(data[i]));    // create list
            linker = linker.getNext();  // move forward
            //System.out.println(linker.toString() + "|");
        }
    }

    public void printList() {
        Element<T> iterator = head;
        while(iterator != null) {
            System.out.println(iterator.toString() + "|");
            iterator = iterator.getNext();
        }
    }

    public void reverseList() {
        reverseList(head);
    }

    private Element<T> reverseList(Element<T> head) {
        if(head.getNext() == null) {
            //this.head = head;
            return head;
        }
        Element<T> curr = reverseList(head.getNext());
        curr.setNext(head);
        head.setNext( null );
        return head;
    }

    public Element<T> get(int idx) {
        Element<T> ret = head;
        for(int i=1; i<idx; i++)
            ret = ret.getNext();
        return ret;
    }

    public void delete(Element<T> toRemove) {
        if(toRemove == head)
            head = head.getNext();
        Element<T> curr = head;
        Element<T> prev = null;

        while(curr.getNext() != null) {
            if(toRemove == curr.getNext()) {
                curr.setNext(curr.getNext().getNext());
                toRemove.setNext( null );
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }

        if(toRemove == curr)
            prev.setNext( null );

    }

    public static LinkedList<Integer> addLists(LinkedList<Integer> a1, LinkedList<Integer> a2) {
        byte carry = 0;  // variable for the carry
        Element<Integer> currA1 = a1.head;
        Element<Integer> currA2 = a2.head;

        LinkedList<Integer> result = new LinkedList<Integer>();
        Element<Integer> currResult = result.head;  // iterator for results list
        Element<Integer> prevResult = currResult;   // to get end of results list

        while((currA1 != null) && (currA2 != null)) {
            int localResult = currA1.get() + currA2.get();  // add to get local result
                                                            // carry can never be > 1
            localResult = localResult + carry;

                currResult.set(localResult%10);
                carry = (byte) ((localResult >= 10) ? 1: 0);

            prevResult = currResult;
            currResult.setNext(new Element<Integer>());
            currResult = currResult.getNext();  // move forward
            currA1 = currA1.getNext();
            currA2 = currA2.getNext();  // iterate forward
        }

        if(currA1 == null && currA2 != null) {
            complete(currResult, currA2, carry);
        }
        else if (currA2 == null && currA1 != null) {
            complete(currResult, currA1, carry);
        }
        else  { // both lists of equal length
            if(carry != 0)
                currResult.set((int) carry);  //set last elem to carry value
            else
                prevResult.setNext( null );
        }
        return result;
    }

    private static void complete(Element<Integer> result, Element<Integer> array, byte carry) {
        int localResult;
        Element<Integer> prevResult = result;
        while(array != null) {
            localResult = array.get() + carry;
            result.set(localResult%10);
            carry = (byte) ((localResult >= 10) ? 1: 0);
            result.setNext(new Element<Integer>());
            prevResult = result;
            result = result.getNext();  // move forward
            array = array.getNext();
        }

        if(carry != 0)
            result.set((int) carry);  //set last elem to carry value
        else
            prevResult.setNext( null );
    }

    public Element<T> reverseEveryK(int k) {
        Element<T> currHead = head; // to iterate
        Element<T> iterator = head;
        Element<T> tempIterator = iterator;
        Element<T> prevHead = null;
        int len = 1;
        while(iterator.getNext() != null) {
            if(len%k == 0 || iterator.getNext().getNext() == null) {
                //iterator = (iterator.getNext().getNext() == null)?iterator.getNext():iterator;
                tempIterator = iterator.getNext();  // store next in chain
                iterator.setNext( null );   // make this the new tail
                Element<T> kListTail = reverseList(currHead); // tail end recursion
                kListTail.setNext( prevHead );
                prevHead = iterator;
                currHead = tempIterator;
                iterator = tempIterator;    // move to next element
            }
            else {
                iterator = iterator.getNext();
            }
            len++;
        }

        tempIterator.setNext( prevHead );
        this.head = tempIterator;   // for printing entire list
        return tempIterator;
    }
}
