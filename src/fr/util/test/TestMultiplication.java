package fr.util.test;

public class TestMultiplication
{

	public static void entete()
	{
		
		System.out.print("| X ");
		
		for(int i = 0; i < 11; i++ )
		{
			
			System.out.print("|");
						
			if( String.valueOf(i).length() == 1 )
			{
				
				System.out.print("  " + i);
			}
			else if( String.valueOf(i).length() == 2 )
			{
				
				System.out.print(" " + i);
			}
			else if( String.valueOf(i).length() == 3 )
			{
				
				System.out.print("" + i);
			}
			
		}
		
		System.out.println("|");
		
	}
	
	public static void ligne()
	{
		
		System.out.print(" ---");

		for(int i = 0; i < 11; i++ )
		{
			System.out.print(" ---");	
		}
		
		System.out.println("");
	}
	
	
	public static void celluleOperation(String operation)
	{
		
		if("M".equals( operation )   )
		{
			System.out.print("| X ");	
		}
		if("A".equals( operation )   )
		{
			System.out.print("| + ");	
		}
		
		
		
	}
	
	public static void cellule(int entier)
	{

		System.out.print("|");
		
		if( String.valueOf(entier).length() == 1 )
		{
			
			System.out.print("  " + entier);
		}
		else if( String.valueOf(entier).length() == 2 )
		{
			
			System.out.print(" " + entier);
		}
		else if( String.valueOf(entier).length() == 3 )
		{

			System.out.print("" + entier);
		}
		
	}
	
	public static void enteteFin()
	{
		System.out.println("|");
	}	
	
	public static void celluleFin()
	{

		
	}
		
	public static void main(String[] args)
	{

		System.out.println("Bonjour Justine !");
		
		System.out.println("");

		// Ligne d'entête
		celluleOperation("M");
		
		for(int i = 0; i < 11; i++ )
		{
			
			cellule( i );
			
		}
		
		enteteFin();
		
		// 
		
		
		
		
		/*		

		entete();
		
		| X |  0|  1|  2|  3|  4|  5|  6|  7|  8|  9| 10
		
		ligne();
	
		for(int j = 0; j < 11; j++ )
		{
		
			System.out.print("|");

			if( String.valueOf(j).length() == 1 )
			{
				
				System.out.print("  " + j);
			}
			else if( String.valueOf(j).length() == 2 )
			{
				
				System.out.print(" " + j);
			}
			else if( String.valueOf(j).length() == 3 )
			{

				System.out.print("" + j);
			}
			
			for(int i = 0; i < 11; i++ )
			{
				
				int m = i * j;
				
				System.out.print("|");
				
				if( String.valueOf(m).length() == 1 )
				{
					
					System.out.print("  " + m);
				}
				else if( String.valueOf(m).length() == 2 )
				{
					
					System.out.print(" " + m);
				}
				else if( String.valueOf(m).length() == 3 )
				{
					
					System.out.print("" + m);
				}
							
			}
			
			System.out.println("|");

			
			
			ligne();

			
			
		}		
		*/
		
	}

}
