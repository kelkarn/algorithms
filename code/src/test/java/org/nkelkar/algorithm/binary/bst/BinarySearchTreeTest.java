package org.nkelkar.algorithm.binary.bst;

import org.junit.Assert;
import org.junit.Test;
import org.nkelkar.algorithm.tree.binary.bst.BinarySearchTree;
import org.nkelkar.algorithm.tree.binary.util.Node;

/**
 * User: dell
 * Date: 1/31/14
 * Time: 9:21 PM
 */
public class BinarySearchTreeTest {

    @Test
    public void testBinarySearchTreeBuild() {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(new Integer[] {1, 2, 4, 5, 6});
        // following should print "1, 2, 4, 5, 6"
        myTree.inOrderPrint();
    }

    @Test
    public void testIsBinarySearchTree() {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(new Integer[] {1, 2, 4, 5, 6});
        Assert.assertTrue("failure - the tree created was not a binary search tree as expected",
                myTree.isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testBinaryTreeInsert() {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(new Integer[] {1, 2, 4, 27, 36, 45, 49});
        myTree.insert(new Node<Integer>( 21 ));

        Assert.assertTrue(myTree.contains( 21 ));
        Node<Integer> ref = myTree.getReference( 49 );
        Assert.assertNull("", myTree.successor(ref));
    }

    @Test
    public void testIsSymmetric() {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(new Integer[] {1, 2, 4, 27, 36, 45, 49});
        myTree.insert(new Node<Integer>( 51 ));
        Assert.assertFalse(myTree.isSymmetric());
    }

    @Test
    public void testTreeCopy() {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(new Integer[] {1, 2, 4, 27, 36, 45, 49});

        myTree.insert(new Node<Integer>( 51 ));

        BinarySearchTree<Integer> myNewTree = new BinarySearchTree<Integer>(BinarySearchTree.copyTree(myTree.getRoot()));
        myNewTree.inOrderPrint();
    }
}
