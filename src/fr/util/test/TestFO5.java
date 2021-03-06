package fr.util.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TestFO5
{
	
	public static void main( String[] args )
	{
		
		BufferedReader bufferedReader;
		
		FileReader fileReader;
		
		FileWriter fileWriter;
		StringBuffer stringBuffer;
		int i = 0;
		String line;

		String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
		String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
		
		try
		{

			fileReader = new FileReader( pathIn + "\\" + "list_in.txt" );
						
			bufferedReader = new BufferedReader( fileReader );
			
			stringBuffer = new StringBuffer();
			
			while( ( line = bufferedReader.readLine() ) != null )
			{
				
				i++;

				line = "INSERT INTO 'T_DIF_LISTENOIRE' ('ID', 'MAIL') VALUES ('" + i + "', '" + line + "'),";
				
				stringBuffer.append( line ).append( "\r" );

			}

			fileWriter = new FileWriter( pathOut + "\\" + "scriptDIF.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();
			
		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
		}

	}

}
