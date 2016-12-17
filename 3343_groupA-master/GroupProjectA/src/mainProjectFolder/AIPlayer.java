package mainProjectFolder;

/**
 * The AI for the computer player to play against the user.
 * 
 * @author John Kelley
 *
 */
public class AIPlayer extends Player {

	private static final long serialVersionUID = 1L;

	/**
	 * All ways uses the first card for right now.
	 * 
	 * @return The card it is using
	 */
	public int makeMove() {
		return useCard(1);
	}
}
