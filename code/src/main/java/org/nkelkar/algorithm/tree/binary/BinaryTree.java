package org.nkelkar.algorithm.tree.binary;

import org.nkelkar.algorithm.tree.binary.util.Node;

/**
 * User: dell
 * Date: 1/23/14
 * Time: 12:15 AM
 */
public class BinaryTree<T extends Comparable<T>> {    // this class is still under construction

    protected Node<T> root;

    public BinaryTree() {
        root = new Node<T>(null);   // no data yet
    }

    // these are for public use
    public void inOrderPrint() {
        inOrderPrint(root);
    }

    public void preOrderPrint() {
        preOrderPrint(root);
    }

    public void postOrderPrint() {
        postOrderPrint(root);
    }

    // these are internal to the BinaryTree
    private void postOrderPrint(Node<T> root) {

        if(root == null) {
            return;
        }

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println("--> " + root.toString());
    }

    private void preOrderPrint(Node<T> root) {

        if(root == null) {
            return;
        }

        System.out.println("--> " + root.toString());
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    private void inOrderPrint(Node<T> root) {

        if(root == null) {
            return;
        }

        inOrderPrint(root.left);
        System.out.println("--> " + root.toString());
        inOrderPrint(root.right);
    }

    public boolean isBinarySearchTree(T MIN, T MAX) {
        return isBST(this.root, MIN, MAX);
    }

    private boolean isBST(Node<T> root, T lowerLimit, T upperLimit) {
        return root == null || root.compareTo(lowerLimit) > 0 && root.compareTo(upperLimit) <= 0
               && isBST(root.left, lowerLimit, root.getData()) && isBST(root.right, root.getData(), upperLimit);
    }

    public boolean isSymmetric() {

        return isSymmetric(this.root.left, this.root.right);
    }

    private boolean isSymmetric(Node<T> left, Node<T> right) {
        if((left == null) && (right == null))   // reached a leaf node
            return true;
        else if((left == null && right != null) || (left != null && right == null))
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }

    public static Node copyTree(Node copyFrom) {

        if(copyFrom == null)
            return null;

        Node copyTo = new Node(copyFrom.getData());

        copyTo.left = copyTree(copyFrom.left);
        copyTo.right = copyTree(copyFrom.right);

        return copyTo;
    }
}
