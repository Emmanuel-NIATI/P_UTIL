package fr.util.test;

public class TestOperation
{

	// Ecrit une chaîne de caractère
	public static void ecrire( String chaine )
	{
	
		System.out.print( chaine );
		
	}
	
	// Retour à la ligne (touche entrée)
	public static void retour()
	{
	
		System.out.println("");
		
	}

	// Cellule Plus
	public static void celluleSigne()
	{
	
		System.out.print("| + ");
		
	}
	
	// Cellule chiffre
	public static void cellule(int n)
	{
	
		ecrire("|");
		
		if( String.valueOf(n).length() == 1 )
		{
			
			ecrire("  " + n);
		}
		else if( String.valueOf(n).length() == 2 )
		{
			
			ecrire(" " + n);
		}
		else if( String.valueOf(n).length() == 3 )
		{
			
			ecrire("" + n);
		}
		
	}
	
	// Ligne
	public static void ligne(int l)
	{
		
		cellule(l);
		
		for(int i=0; i<11; i++)
		{
			
			int a = 0;
			
			a = i + l;
						
			cellule(a);
		}
		
		ecrire("|");
		retour();
		
	}	
	
	// Programme principal
	public static void main(String[] args)
	{

		ecrire("Bonjour Justine !");
		retour();
		
		retour();
		
		ecrire("Additionner ou Multiplier ?");
		retour();

		retour();
		
		// Ligne entête
		celluleSigne();
		
		for(int i=0; i<11; i++)
		{
			
			cellule(i);
		}
		
		ecrire("|");
		retour();
		
		// Lignes de la table
		
		for(int j=0; j<11; j++)
		{
			
			ligne(j);
		}
		
		
	}

}
