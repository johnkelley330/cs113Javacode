package hashMapTest;
import java.io.File;
import hashMap.HashtableChain;
import java.io.IOException;
import java.util.Scanner;
/**
 * A class that quickly tests the HashtableChain class.
 * @author John Kelley
 *
 */
public class HashCodeTester {

	public static void main(String[] args) {
		try{
			Scanner in = new Scanner(new File("src\\hashMapTest\\phoneBook.txt"));
			HashtableChain<String, PhoneEntry> hashtable = new HashtableChain<String, PhoneEntry>();
			System.out.println("Testing isEmpty");
			System.out.println(hashtable.isEmpty());
			while(in.hasNext()){
				hashtable.put(in.next(), new PhoneEntry(in.next(), in.next(), in.next(), in.next()));
			}
			in.close();
			System.out.println("Testing toString");
			System.out.println(hashtable.toString());
			System.out.println("Testing size");
			System.out.println(hashtable.size());
			System.out.println("Testing get");
			System.out.println(hashtable.get("john"));
			System.out.println(hashtable.get("jill"));
			System.out.println(hashtable.get("kelley"));
			System.out.println(hashtable.get("notInTheTable"));
			System.out.println("Testing remove");
			System.out.println(hashtable.remove("jill"));
			System.out.println(hashtable.toString());
			System.out.println("Testing size");
			System.out.println(hashtable.size());
			System.out.println("Testing isEmpty");
			System.out.println(hashtable.isEmpty());
		} catch(IOException ex){
			System.out.println("There was an error.");
		}

	}

}
