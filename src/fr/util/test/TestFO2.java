package fr.util.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFO2
{
	
	public static void main( String[] args )
	{
		
		BufferedReader bufferedReader;
		FileReader fileReader;
		FileWriter fileWriter;
		StringBuffer stringBuffer;
		String line;

		String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
		String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
		
		try
		{

			fileReader = new FileReader( pathIn + "\\" + "list_in2.txt" );
			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();
			
			while( ( line = bufferedReader.readLine() ) != null )
			{

				int indexDebut = line.indexOf("'");				

				line = line.substring( indexDebut + 1 );
				
				int indexFin = line.indexOf("'");
				
				line = line.substring( 0, indexFin );

				stringBuffer.append( line ).append("\r");
				
			}
			
			fileWriter = new FileWriter( pathOut + "\\" + "list_out2.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
		}

	}

}
