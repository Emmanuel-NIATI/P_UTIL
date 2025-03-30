package fr.util.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestText
{
	
	public static void main(String[] args)
	{

		BufferedReader bufferedReader;
		FileReader fileReader;
		PrintWriter printWriter;

		String line;
		
		FileWriter fileWriter;
		
		String sFileIn = "C:\\Users\\emman\\eclipse-working\\in\\technique.txt";
		String sFileOut = "C:\\Users\\emman\\eclipse-working\\out\\technique.txt";

		try
		{

			fileReader = new FileReader( sFileIn );
			bufferedReader = new BufferedReader( fileReader );

			printWriter = new PrintWriter(sFileOut, "UTF-8");
			
			while ( (line = bufferedReader.readLine()) != null )
			{
				
				System.out.println( "Read Line Buffered Reader : " + "line : " + line );
				
				if( line.endsWith("@intradef.gouv.fr") )
				{

					
					
					printWriter.println(line);

				}

			}

			printWriter.close();;			

		}
		catch (FileNotFoundException fnfe)
		{

			System.out.println( "File Not Found Exception : " + fnfe.getMessage() );
			
		}
		catch (IOException ioe)
		{
			
			System.out.println( "IO Exception : " + ioe.getMessage() );
			
		}
		catch (Exception e)
		{
			
			System.out.println( "Exception : " + e.getMessage() );
			
		}
		
	}

}
