package test;

import java.util.Random;

import trees.AVLTree;
import trees.BinarySearchTree;
/**
 * This class test the AVL tree and compares it to the BTS for insertions.
 * @author W7258645
 *
 */
public class TestForAVLTree {
	public static void main(String[] args){
		AVLTree<Integer> testAVLTree = new AVLTree<Integer>();
		BinarySearchTree<Integer> testBTSTree = new BinarySearchTree<Integer>();
		Random rand = new Random();
		int randInt = 0;
		for(int i = 0; i < 100; i++){
			randInt = rand.nextInt(1000) + 1;
			testAVLTree.add(randInt);
			testBTSTree.add(randInt);
		}
		System.out.println("AVL Tree After Insertions");
		System.out.println("-------------------------");
		System.out.println(testAVLTree.toString());
		System.out.println("Binary Search Tree After Insertions");
		System.out.println("-----------------------------------");
		System.out.println(testBTSTree.toString());
	}
}
