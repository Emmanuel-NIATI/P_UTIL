package fr.util.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestText
{
	
	public static void main(String[] args)
	{

		BufferedReader bufferedReader;
		FileReader fileReader;
		StringBuffer stringBuffer;

		int l = 0;
		String line;

		int index;
		
		FileWriter fileWriter;
		
		String sFileIn = "C:\\Users\\emman\\eclipse-working\\in\\terre.txt";
		String sFileOut = "C:\\Users\\emman\\eclipse-working\\out\\terre.txt";

		try
		{

			fileReader = new FileReader( sFileIn );

			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();

			while ( (line = bufferedReader.readLine()) != null)
			{

				System.out.println( "Read Line Buffered Reader : " + "line : " + l );
				
				System.out.println( "Read Line Buffered Reader : " + "line : " + line );

				if( line.endsWith("@intradef.gouv.fr") )
				{

					stringBuffer.append(line);
					stringBuffer.append("\r");

				}

				l++;

			}

			System.out.println( "String Buffer : " + "taille : " + stringBuffer.length() );
			
			fileWriter = new FileWriter( sFileOut );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

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
