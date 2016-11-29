package test;

import java.util.Random;

import trees.AVLTree;

public class TestForAVLTree {
	public static void main(String[] args){
		AVLTree<Integer> testTree = new AVLTree<Integer>();
		Random rand = new Random();
		int r = 0;
		for(int i = 0; i < 100; i++){
			r = rand.nextInt(50);
			testTree.add(r);
		}
		System.out.println(testTree.toString());
	}
}
