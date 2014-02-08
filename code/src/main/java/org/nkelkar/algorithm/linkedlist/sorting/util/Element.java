package org.nkelkar.algorithm.linkedlist.sorting.util;

/**
 * User: dell
 * Date: 1/26/14
 * Time: 6:16 PM
 */
public class Element<T extends Comparable<? super T>>  {
    private T data;
    private Element<T> next;    // pointer to next elem

    public Element() {
        this.data = null;
        this.next = null;
    }

    public Element(T data) {
        this.data = data;
        next = null;
    }

    public T get() {
        return data;
    }

    public void set(T data) {
        this.data = data;
    }

    public void setNext(Element<T> elem) {
        this.next = elem;
    }

    public String toString() {
        return data.toString(); // use toString method on data
    }

    public Element<T> getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return !(next == null);
    }

    public int compareTo(Element<T> other) {

        if(this.data.compareTo(other.data) == 0)
            return 0;

        else if(this.data.compareTo(other.data) < 0)
            return -1;

        return 1;
    }
}
