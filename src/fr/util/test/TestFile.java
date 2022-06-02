package fr.util.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

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

		Properties p = System.getProperties();
		
		System.out.println( p.getProperty("file.encoding") );

		
		
		
		String pathIn = "C:\\Users\\emman\\eclipse-workspace";
		File fileIn = new File(pathIn);

		describeFile(fileIn);

	}

}
