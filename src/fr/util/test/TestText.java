package fr.util.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestText
{
	
	String sFileIn = "C:\\Users\\emman\\eclipse-working\\in\\tous_02.txt";
	String sFileOut = "C:\\Users\\emman\\eclipse-working\\out\\tous_02.txt";
	
	public TestText()
	{
		
	}
	
	public void analyseText()
	{
		
		BufferedReader bufferedReader;
		FileReader fileReader;
		PrintWriter printWriter;
		String line;
		FileWriter fileWriter;

		try
		{

			fileReader = new FileReader( sFileIn );
			bufferedReader = new BufferedReader( fileReader );
			
			while ( (line = bufferedReader.readLine()) != null )
			{

				System.out.print( "Read Line Buffered Reader : " + "line : " + line );
				
				if( line.contains("intradef.gouv.fr"))
				{
					
					System.out.println( " OK !!!!");
					
				}
				else
				{
					System.out.println( "");
				}
				
			}

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

	
	
	
	public void convertText()
	{
		
		BufferedReader bufferedReader;
		FileReader fileReader;
		PrintWriter printWriter;
		String line;

		try
		{

			fileReader = new FileReader( sFileIn );
			bufferedReader = new BufferedReader( fileReader );

			printWriter = new PrintWriter(sFileOut, "UTF-8");
			
			while ( (line = bufferedReader.readLine()) != null )
			{

							
				System.out.println( "Read Line Buffered Reader : " + "line : " + line );
				
				line = line.toLowerCase();
				
				System.out.println( "Read Line Buffered Reader : " + "line : " + line );
				
				if( line.contains("@intradef.gouv.fr") );
				{
					
					System.out.println( "@intradef.gouv.fr : " + "OK !!!");
					
					line = line.strip();
					
					char[] str = line.toCharArray();
					
					for(int i=0; i< str.length; i++)
					{
						System.out.println( "str[" + i + "]" + " " + str[i] );	
					}

					System.out.println( "Write Line : " + "line : " + line );
					printWriter.println(line);

				}

			}

			printWriter.close();

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
		
	
	
	public static void main(String[] args)
	{

		TestText testText = new TestText();

		// testText.analyseText();
		
		testText.convertText();
		
	}

}
