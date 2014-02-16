package org.nkelkar.algorithm.tree.binary.bst;

import org.nkelkar.algorithm.tree.binary.BinaryTree;
import org.nkelkar.algorithm.tree.binary.util.Node;

/**
 * User: nkelkar
 * Date: 1/31/14
 * Time: 9:18 PM
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {


    public BinarySearchTree(Node<T> root) {
        this.root = root;   // tree shallow-copy constructor
    }

    /**
     * this constructor assumes a
     * sorted array as input
     * @param dataArr
     */
    public BinarySearchTree( T[] dataArr) {
        super();    // call parent constructor
        int length = dataArr.length;
        // recursively assign to root the left
        // and right sub-trees
        //this.root = null;
        this.root = recursiveBuild(dataArr, 0, length-1);
    }

    private Node<T> recursiveBuild(T[] data, int start, int end) {
        if(end < start) {
            return null;
        }

        if(start == end) {
            return new Node<T>(data[ start ]);
        }

        int mid = (start+end)/2;
        Node<T> root = new Node<T>(data[ mid ]);

        root.left = recursiveBuild( data, start, mid-1);
        root.right = recursiveBuild(data, mid+1, end);

        return root;
    }

    public void insert(Node<T> newNode) {
        insert(this.root, newNode);
    }

    private void insert(Node<T> root, Node<T> newNode) {

        if(root.compareTo(newNode) <= 0) {
            if(root.right != null)
                insert(root.right, newNode);
            else
                root.right = newNode;
        }
        else {
            if(root.left != null)
                insert(root.left, newNode);
            else
                root.left = newNode;
        }
    }

    public boolean contains(T key) {
        return contains(this.root, key);
    }

    private boolean contains(Node<T> root, T key) {

        if(root == null)
            return false;

        if(root.compareTo(key) == 0)
            return true;

        if(root.compareTo(key) < 0)
            return contains(root.right, key);
        else
            return contains(root.left, key);
    }

    public Node<T> successor(Node<T> target) {
        if(target.right != null) {
            Node<T> ret = target.right;
            while(ret.left != null)
                ret = ret.left;
            return ret;
        }
        else
            return recursiveSuccessor(null, this.root, target);
    }

    private Node<T> recursiveSuccessor(Node<T> parent, Node<T> curr, Node<T> target) {

        if (curr == null)
            return null;

        Node<T> endCurr = null;

        if(target.compareTo( curr ) == 0) {
            if(parent == null)
                return null;
            else {
                if(parent.left == curr)
                    return parent;
            }
                return null;
        }
        else if(target.compareTo( curr ) < 0) {
            endCurr = recursiveSuccessor(curr, curr.left, target);
        }
        else if(target.compareTo( curr ) > 0) {
            endCurr = recursiveSuccessor(curr, curr.right, target);
        }

        if(endCurr == null) {
            if(parent == null || parent.left != curr)
                return null;
            else
                return parent;
        }

        return endCurr;
    }

    public Node<T> getReference(T data) {
         Node<T> it = this.root;

        while(it != null) {
            if (it.compareTo( data ) == 0)
                break;
            if(it.compareTo( data ) > 0)
                it = it.left;
            else
                it = it.right;
        }

        return (it == null) ? null : it;
    }

    public Node<T> getRoot() {
        return this.root;
    }
}
