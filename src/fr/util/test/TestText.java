package fr.util.test;

import java.awt.GridBagConstraints;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestText
{
	
	public static void traitementJava()
	{
		
		String fileOut = "C:\\Users\\emman\\eclipse-working\\out\\monFichier.txt";
		
		StringBuffer sb = new StringBuffer();
		
		FileWriter fichier;

		try
		{

			for(int j = 0; j < 4; j++)
			{
			
				for(int i = 0; i < 16; i++)
				{

					sb.append( "gridBagConstraintsCenterClock.fill = GridBagConstraints.HORIZONTAL;" ).append( "\n" );
					sb.append( "gridBagConstraintsCenterClock.gridwidth = 1;" ).append( "\n" );
					sb.append( "gridBagConstraintsCenterClock.gridheight = 1;" ).append( "\n" );
					sb.append( "gridBagConstraintsCenterClock.gridx = " + i + ";" ).append( "\n" );
					sb.append( "gridBagConstraintsCenterClock.gridy = " + j + ";" ).append( "\n" );
					sb.append( "jPanelCenterClock.add(jLabelIconCenterClock_0" +i+ "_0" +j+ ", gridBagConstraintsCenterClock);" ).append( "\n" );
					sb.append( "\n" );
					
				}

			}

			fichier = new FileWriter( fileOut );
		    fichier.write ( sb.toString() );
		    fichier.close();

		} 
		catch (IOException e)
		{

			e.printStackTrace();
		}

		
	}
	
	public static void traitementBlacklist()
	{
		
	}	
	
	public static void main(String[] args)
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

			fileReader = new FileReader( pathIn + "\\" + "blacklist.txt" );

			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();
						
			while ( (line = bufferedReader.readLine()) != null)
			{
				
				stringTokenizer = new StringTokenizer( line, ";" );
				
				if ( stringTokenizer.hasMoreTokens() )
				{
					
					String nextToken = stringTokenizer.nextToken();
					
					stringBuffer.append( line.substring( nextToken.length()+1 ) ).append("\r");

				}
				
			}

			fileWriter = new FileWriter( pathOut + "\\" + "blacklist.txt" );
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
		
	}

}
