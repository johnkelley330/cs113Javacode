package driver;
import trees.MorseCodeTree;
/**
 * The driver for the morseCodeTree.
 * uses the menu class for a nice menu.
 * @author John Kelley
 *
 */
public class Driver {
	public static void main(String[] args){
		MorseCodeTree mct = new MorseCodeTree();
		Menu m = new Menu();
		m.menu(mct);
	}
}