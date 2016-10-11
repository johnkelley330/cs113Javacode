package changeFinder;

public class ChangeFinder {
	private int quarter;
	private int dime;
	private int nickel;
	private int penny;

	/**
	 * Initialize all the variables to zero.
	 */
	public ChangeFinder() {
		quarter = 0;
		dime = 0;
		nickel = 0;
		penny = 0;
	}

	/**
	 * Prints all the combinations of change that add up to the amount.
	 * 
	 * @param amout
	 *            The amount to be evaluated for change.
	 */
	public void findChange(double amount) {
		System.out.printf("The Change for %.2f\n", amount);
		int amountInterger = (int) (amount * 100);
		System.out.println("Quarter Dime nickel Penny");
		System.out.println("------- ---- ------ -----");
		if (amountInterger == 0) {
			System.out.printf("%7d %4d %6d %5d\n", quarter, dime, nickel, penny);
		} else {
			penny(amountInterger);
			nickel(amountInterger);
			dime(amountInterger);
			quarter(amountInterger);
		}
	}

	public void penny(int amount) {
		if (amount >= 1) {
			amount -= 1;
			penny++;
			if (amount == 0) {
				System.out.printf("%7d %4d %6d %5d\n", quarter, dime, nickel, penny);
			} else {
				penny(amount);
				nickel(amount);
				dime(amount);
				quarter(amount);
			}
			amount += 1;
			penny--;
		}
	}

	public void nickel(int amount) {
		if (amount >= 5) {
			amount -= 5;
			nickel++;
			if (amount == 0) {
				System.out.printf("%7d %4d %6d %5d\n", quarter, dime, nickel, penny);
			} else {
				nickel(amount);
				dime(amount);
				quarter(amount);
			}
			amount += 5;
			nickel--;
		}
	}

	public void dime(int amount) {
		if (amount >= 10) {
			amount -= 10;
			dime++;
			if (amount == 0) {
				System.out.printf("%7d %4d %6d %5d\n", quarter, dime, nickel, penny);
			} else {
				dime(amount);
				quarter(amount);
			}
			amount += 10;
			dime--;
		}
	}

	public void quarter(int amount) {
		if (amount >= 25) {
			amount -= 25;
			quarter++;
			if (amount == 0) {
				System.out.printf("%7d %4d %6d %5d\n", quarter, dime, nickel, penny);
			} else {
				quarter(amount);
			}
			amount += 25;
			quarter--;
		}
	}
}