package fr.util.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestFO1
{
	
	public static void main( String[] args )
	{
		
		BufferedReader bufferedReader;
		FileReader fileReader;
		FileWriter fileWriter;
		StringBuffer stringBuffer;
		StringTokenizer stringTokenizer;

		String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
		String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
		
		try
		{

			fileReader = new FileReader( pathIn + "\\" + "list_in1.txt" );
			bufferedReader = new BufferedReader( fileReader );

			String line;

			line = bufferedReader.readLine();

			stringTokenizer = new StringTokenizer( line, ";" );
			
			stringBuffer = new StringBuffer();
			
			while ( stringTokenizer.hasMoreTokens() )
			{
				
				String nextToken = stringTokenizer.nextToken();

				int indexDebut = nextToken.indexOf("<");
				
				nextToken = nextToken.substring( indexDebut + 1 );

				int indexFin = nextToken.indexOf(">");
				
				nextToken = nextToken.substring( 0, indexFin );

				stringBuffer.append( nextToken ).append("\r");

			}
			
			fileWriter = new FileWriter( pathOut + "\\" + "list_out1.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
		}

	}

}
