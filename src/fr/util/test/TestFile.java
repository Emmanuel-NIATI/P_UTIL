package fr.util.test;

import java.io.File;
import java.util.ArrayList;

public class TestFile
{

	public static void describeFile(File fileIn_)
	{

		File[] files = fileIn_.listFiles();
		File file;

		for(int i = 0; i < files.length; i++ )
		{

			file = files[i];
			
			if( file.isDirectory() )
			{
			
				System.out.println( "\t" + "répertoire : " + file.getName() );
				describeFile(file);
			}
			else if( file.isFile() )
			{
			
				System.out.println( "\t" + "fichier : " + file.getName() );
				
			}
			else
			{
				
			}
			
		}
		
	}
	
	public static void main(String[] args)
	{

		String pathIn = "C:\\Users\\emman\\eclipse-workspace";
		File fileIn = new File(pathIn);

		describeFile(fileIn);

	}

}
