package main;

import static java.lang.System.*;

import java.io.*;
import java.util.*;

public class BinarySearchTree {

	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	@SuppressWarnings("unchecked")
	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null) 
			tree = new TreeNode(val);

		Comparable treeValue = tree.getValue();
		int dirTest = -1;
		if (val.getClass().getName().equals(treeValue.getClass().getName()))
			dirTest = val.compareTo(treeValue);

		if (dirTest < 0) 
			tree.setLeft(add(val, tree.getLeft())); 
		else if (dirTest > 0) 
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	private static enum IterationMode {
		IN_ORDER,
		PRE_ORDER,
		POST_ORDER,
		REVERSE_ORDER
	}

	public void inOrder() {
		StringBuffer string = new StringBuffer();
		traverse(root, IterationMode.IN_ORDER, string);
		System.out.println(string);
	}

	public void preOrder() {
		StringBuffer string = new StringBuffer();
		traverse(root, IterationMode.PRE_ORDER, string);
		System.out.println(string);
	}

	public void postOrder() {
		StringBuffer string = new StringBuffer();
		traverse(root, IterationMode.POST_ORDER, string);
		System.out.println(string);
	}

	public void reverseOrder() {
		StringBuffer string = new StringBuffer();
		traverse(root, IterationMode.REVERSE_ORDER, string);
		System.out.println(string);
	}

	private void traverse(final TreeNode node, final IterationMode mode, Appendable output) {
		if (node == null)
			return;

		try {
			switch (mode) {
			// left node right
			case IN_ORDER:
				traverse(node.getLeft(), mode, output);
				output.append(node.getValue().toString() + " ");
				traverse(node.getRight(), mode, output);
				break;

			// node left right
			case PRE_ORDER:
				output.append(node.getValue().toString() + " ");
				traverse(node.getLeft(), mode, output);
				traverse(node.getRight(), mode, output);
				break;

			// left right node
			case POST_ORDER:
				traverse(node.getLeft(), mode, output);
				traverse(node.getRight(), mode, output);
				output.append(node.getValue().toString() + " ");
				break;

			// right node left
			case REVERSE_ORDER:
				traverse(node.getRight(), mode, output);
				output.append(node.getValue().toString() + " ");
				traverse(node.getLeft(), mode, output);
				break;
			}
		} 

		catch (IOException ioerr) {
			ioerr.printStackTrace();
		}
	}

	public void levelOrder() {
		levelOrder(root);
		System.out.println();
	}

	private void levelOrder(TreeNode tree) {
		if (tree == null) 
			return;

		Queue<TreeNode> level = new LinkedList<TreeNode>();
		level.add(tree);

		while (!level.isEmpty()) {
			TreeNode node = level.remove();

			out.print(node.getValue() + " ");

			if (node.getLeft() != null)
				level.add(node.getLeft());

			if (node.getRight() != null)
				level.add(node.getRight());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root, 1);
	}

	private int getNumLevels(TreeNode tree, int depth) {
		if (tree == null)
			return 0;
		return Math.max(depth, Math.max(getNumLevels(tree.getLeft(), depth+1), getNumLevels(tree.getRight(), depth+1)));
	}

	// Complete the traversals and the toString method
	// and then each of these:

	// clear()
	public void clear() {
		root = null;
	}

	//getNumLeaves
	public int getNumLeaves() {
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode node) {
		if (node == null)
			return 0;
		if (node.getLeft() == null && node.getRight() == null)
			return 1;
		return getNumLeaves(node.getLeft()) + getNumLeaves(node.getRight());
	}

	// getHeight
	public int getHeight() {
		return getNumLevels()-1;
	}

	// getNumNodes
	public int getNumNodes() {
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + getNumNodes(node.getLeft()) + getNumNodes(node.getRight());
	}

	// isFull
	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TreeNode node) {
		if (node == null)
			return false;
		if (node.getLeft() != null && node.getRight() != null)
			return isFull(node.getLeft()) && isFull(node.getRight());
		return node.getRight() == null && node.getLeft() == null;
	}

	private Comparable semiNullCheck(Comparable a, Comparable b) {
		if (a == null)
			return b;
		return a; // can return null!
	}

	// search
	public boolean search(Comparable searchFor) {
		TreeNode result = search(root, searchFor);
		return result == null ? false : result.getValue().equals(searchFor);
	}

	public TreeNode searchForNode(Comparable searchFor) {
		TreeNode result = search(root, searchFor);
		return result == null ? null : result.getValue().equals(searchFor) ? result : null;
	}

	@SuppressWarnings("unchecked")
	private TreeNode search(TreeNode node, final Comparable searchFor) {
		if (node == null)
			return null;

		if (node.getValue().equals(searchFor))
			return node;

		if (searchFor.compareTo(node.getValue()) > 0)
			return search(node.getRight(), searchFor);
		else
			return search(node.getLeft(), searchFor);
	}

	// getSmallest
	public Comparable getSmallest() {
		TreeNode smallest = root;
		while (smallest.getLeft() != null)
			smallest = smallest.getLeft();
		return smallest.getValue();
	}

	// getLargest
	public Comparable getLargest() {
		TreeNode largest = root;
		while (largest.getRight() != null)
			largest = largest.getRight();
		return largest.getValue();
	}

	// getWidth
	public int getWidth() {
		return 1 + getNumLevels(root.getLeft(), 1) + getNumLevels(root.getRight(), 1);
	}

	// remove
	public void remove(Comparable value) {
		root = remove(root, value);
	}

	@SuppressWarnings("unchecked")
	private TreeNode remove(TreeNode node, final Comparable value) {
		if (node == null)
			return null;
		int compare = value.compareTo(node.getValue()); 
		if (compare < 0)
			node = remove(node.getLeft(), value);
		else if (compare > 0)
			node = remove(node.getRight(), value);
		else if (node.getRight() == null)
			node = node.getLeft();
		else {
			TreeNode next = getSmallest(node.getRight());
			node.setRight(remove(next, value));
		}
		return node;
	}

	// Returns a String that represents
	// an IN-ORDER traversal of the tree.
	public String toString() {
		StringBuffer string = new StringBuffer();
		traverse(root, IterationMode.IN_ORDER, string);
		return string.toString();
	}
}
