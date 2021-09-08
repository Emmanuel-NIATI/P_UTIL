package fr.util.test;

public class TestPi
{

	private static double calcul( double n )
	{

		double s = 0;
				
		for(double i = 1; i < (n + 1); i++ )
		{

			s = s + 1 / Math.pow(i, 2);
		}

		return Math.sqrt( 6 * s );

	}
	
	public static void main(String[] args)
	{

		System.out.println( "Pi (précision 5000000) : " + calcul( 5000000 ) );
	}

}
