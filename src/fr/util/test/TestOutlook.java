package fr.util.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TestOutlook
{

	public TestOutlook()
	{
		
	}

	public void manageExportOutlook()
	{

		BufferedReader bufferedReader;
		FileReader fileReader;
		StringBuffer stringBuffer;

		int index = 0;
		
		String line;

		ArrayList<String> listAddress = new ArrayList<String>();
		Iterator<String> iteratorAddress;

		FileWriter fileWriter;

		String sFileIn = "C:\\Users\\emman\\eclipse-working\\in\\triables.txt";
		String sFileOut = "C:\\Users\\emman\\eclipse-working\\out\\triables.txt";

		try
		{

			fileReader = new FileReader( sFileIn );

			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();

			while ( (line = bufferedReader.readLine()) != null)
			{

				System.out.println( "Read Line Buffered Reader : " + line );

				index++;

				String domainName = "";

				String[] parts = line.split("@");
				
				if(parts.length == 2)
				{
					domainName = parts[1];
				}

				if( !listAddress.contains(line) )
				{

					listAddress.add(domainName);

				}
				
				listAddress.sort(null);

			}

			System.out.println( "Taille Buffered Reader : " + index );

			iteratorAddress = listAddress.iterator();
			
			while ( iteratorAddress.hasNext() )
			{
				
				stringBuffer.append(  iteratorAddress.next() ).append("\n");

			}			

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

	public void manageExportOutlookTriable()
	{
		
		BufferedReader bufferedReader;
		FileReader fileReader;
		StringBuffer stringBuffer;

		int index = 0;
		
		String line;

		ArrayList<String> listAddress = new ArrayList<String>();
		Iterator<String> iteratorAddress;

		FileWriter fileWriter;

		String sFileIn = "C:\\Users\\emman\\eclipse-working\\in\\triables.txt";
		String sFileOut = "C:\\Users\\emman\\eclipse-working\\out\\triables.txt";

		try
		{

			fileReader = new FileReader( sFileIn );

			bufferedReader = new BufferedReader( fileReader );
			stringBuffer = new StringBuffer();

			while ( (line = bufferedReader.readLine()) != null)
			{

				System.out.println( "Read Line Buffered Reader : " + line );

				if( !listAddress.contains(line) )
				{

					listAddress.add(line);

				}
				
				listAddress.sort(null);

			}

			iteratorAddress = listAddress.iterator();
			
			while ( iteratorAddress.hasNext() )
			{
				
				stringBuffer.append(  iteratorAddress.next() ).append("\n");

			}			

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
	
	public static void main(String[] args)
	{

		TestOutlook testOutlook = new TestOutlook();
		
		testOutlook.manageExportOutlookTriable();
		
	}

}
