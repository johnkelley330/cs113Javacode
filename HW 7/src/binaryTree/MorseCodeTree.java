package binaryTree;
import java.util.Scanner;
import java.io.*;

public class MorseCodeTree extends BinaryTree {

	public void buildFromFile() {
		try{
			Scanner in = new Scanner(new File("src\\binaryTree\\MorseCode.txt"));
			root = new Node<Character>(' ');
			while(in.hasNext()){
				add(root, in.next().charAt(0), in.next());
			}
			System.out.println(toString());
			in.close();
		} catch(IOException ex){
			ex.printStackTrace();
			System.exit(1);
		}
	}

	private Node<Character> add(Node<Character> node ,char letter, String code){
		if(node == null){
			return new Node<Character>(letter);
		}
		else if(code.charAt(0) == '*'){
			node.left = add(node.left, letter, code.substring(1));
			return node;
		} else{
			node.right = add(node.right, letter, code.substring(1));
			return node;
		}
	}
}
