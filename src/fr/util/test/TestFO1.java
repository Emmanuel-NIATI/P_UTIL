package fr.util.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;
import java.util.StringTokenizer;

public class TestFO1
{
	
	public static void traitement()
	{

		BufferedReader bufferedReader;
		FileReader fileReader;
		
		FileWriter fileWriter;
		StringBuffer stringBuffer;
		
		String line;
		
		StringTokenizer stringTokenizer;

		String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
		String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
		
		try
		{

			fileReader = new FileReader( pathIn + "\\" + "traitement.txt" );
			
			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();

			while ( (line = bufferedReader.readLine()) != null)
			{
				
				stringTokenizer = new StringTokenizer( line, ";" );
				
				if ( stringTokenizer.hasMoreTokens() )
				{
					
					String nextToken = stringTokenizer.nextToken();

					int indexDebut = nextToken.indexOf("<");
					
					nextToken = nextToken.substring( indexDebut + 1 );

					int indexFin = nextToken.indexOf(">");
					
					nextToken = nextToken.substring( 0, indexFin );

					stringBuffer.append( nextToken ).append("\r");

				}

			}

			fileWriter = new FileWriter( pathOut + "\\" + "traitement.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
			
		}
		
	}

	public static void blacklist()
	{

		
		BufferedReader bufferedReader;
		FileReader fileReader;
		
		FileWriter fileWriter;
		StringBuffer stringBuffer;
		
		String line;
		
		int i = 0;
		
		String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
		String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
		
		try
		{

			fileReader = new FileReader( pathIn + "\\" + "blacklist.txt" );
			
			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();

			while ( (line = bufferedReader.readLine()) != null)
			{
				
				i++;
				
				String indice = "" + i;
				
				if( indice.length() == 1 )
				{
					indice = "000" + indice;
				}
				if( indice.length() == 2 )
				{
					indice = "00" + indice;
				}
				if( indice.length() == 3 )
				{
					indice = "0" + indice;
				}
				
				// INSERT INTO `DISTRIBUTION`.`T_DIS_LISTENOIRE` (`ID`, `MAIL`) VALUES ('4408', 'dominique1.borie@intradef.gouv.fr');
				
				stringBuffer.append( "INSERT INTO `DISTRIBUTION`.`T_DIS_LISTENOIRE` (`ID`, `MAIL`) VALUES ('" );
				stringBuffer.append( indice );
				stringBuffer.append( "', " );
				stringBuffer.append( line );
				stringBuffer.append( ");" ).append("\r");
				
			}

			stringBuffer.append( "\r" );
			stringBuffer.append( "commit;" );
			stringBuffer.append( "\r" );
			
			fileWriter = new FileWriter( pathOut + "\\" + "blacklist.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
			
		}

		
	}
	
	public static void main( String[] args )
	{
		
	}

}
