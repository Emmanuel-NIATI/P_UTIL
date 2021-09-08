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

		try
		{

			fileReader = new FileReader( "C:\\Users\\emman\\Documents\\Clock\\in\\list_in2.txt" );
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
			
			fileWriter = new FileWriter( "C:\\Users\\emman\\Documents\\Clock\\out\\list_out2.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
		}

	}

}
