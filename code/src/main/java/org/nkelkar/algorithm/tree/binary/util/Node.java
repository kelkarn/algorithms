package org.nkelkar.algorithm.tree.binary.util;

/**
 * User: dell
 * Date: 1/23/14
 * Time: 12:04 AM
 */

public class Node<T extends Comparable<T>> implements Comparable<T> {
    private T _data;

    // pointers to children
    public Node<T> left;
    public Node<T> right;

    /**
     * constructor that assigns _data and
     * sets pointers of children to null
     * @param data  the data to be stored
     */
    public Node(T data) {
        _data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return _data;
    }

    public boolean isNull() {
        return (_data == null); // check if this node has null data
    }

    public Node<T> left() {
        return new Node<T>(left._data);
    }

    public Node<T> right() {
        return new Node<T>(right._data);
    }

    public String toString() {
        if (_data != null)
            return _data.toString();

        return null;
    }


    public int compareTo(Node<T> o) {
        return this._data.compareTo(o._data);
    }

    @Override
    public int compareTo(T o) {
        return this._data.compareTo( o );
    }
}
