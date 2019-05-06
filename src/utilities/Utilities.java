package utilities;

import java.util.Random;

/**
 * This is a model class with auxiliar methods for calculating some values needed
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class Utilities {
	
	private static Random random = new Random();
	
	/**
    * Adds an edge to the graph between two nodes with a given weight
    * @param m is a <code> double </code>
    * @return a <code> double </code> that is -m*log(1-y), where y is a random number between 0 and 1.
    */
	public static double expRandom(double m) {
		double next = random.nextDouble();
		return -m*Math.log(1.0-next);
	}

}
