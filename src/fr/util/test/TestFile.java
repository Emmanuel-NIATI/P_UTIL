package fr.util.test;

import java.io.File;
import java.util.ArrayList;

public class TestFile
{

	public static void main(String[] args)
	{
		
		String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
				
		File fileIn = new File( pathIn ); 

		File[] files = fileIn.listFiles();
		File file;

		for(int i = 0; i < files.length; i++ )
		{

			file = files[i];

			if( file.isDirectory() )
			{

				System.out.print("répertoire : " + file.getName() + "\t" );
				
				File[] fics = file.listFiles();     
				File fic;
				int nbr = 0;
				
				for(int j = 0; j < fics.length; j++ )
				{
					
					fic = fics[j];
					
					if( fic.isFile() )
					{
						nbr++;
						//System.out.println( "fichier : " + fic.getName() );
					}
					
				}
				
				System.out.println( "" + nbr + " fichiers" );
				
				System.out.println("");
				
			}
			
		}

	}

}
