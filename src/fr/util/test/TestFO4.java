package fr.util.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TestFO4
{
	
	public static void main( String[] args )
	{
		
		BufferedReader bufferedReader1;
		BufferedReader bufferedReader2;
		BufferedReader bufferedReader3;
		
		FileReader fileReader1;
		FileReader fileReader2;
		FileReader fileReader3;

		ArrayList al;
		Iterator it;
		
		FileWriter fileWriter;
		StringBuffer stringBuffer;
		String line;

		try
		{

			fileReader1 = new FileReader( "C:\\Users\\emman\\Documents\\Clock\\in\\list_out1.txt" );
			fileReader2 = new FileReader( "C:\\Users\\emman\\Documents\\Clock\\in\\list_out2.txt" );
			fileReader3 = new FileReader( "C:\\Users\\emman\\Documents\\Clock\\in\\list_out3.txt" );
						
			bufferedReader1 = new BufferedReader( fileReader1 );
			bufferedReader2 = new BufferedReader( fileReader2 );
			bufferedReader3 = new BufferedReader( fileReader3 );
			
			al = new ArrayList();
						
			while( ( line = bufferedReader1.readLine() ) != null )
			{
				
				if ( !al.contains( line ) )
				{
					
					al.add( line );
					
				}
				
			}
			
			while( ( line = bufferedReader2.readLine() ) != null )
			{
				
				if ( !al.contains( line ) )
				{
					
					al.add( line );
					
				}
				
			}
			
			while( ( line = bufferedReader3.readLine() ) != null )
			{
				
				if ( !al.contains( line ) )
				{
					
					al.add( line );
					
				}
				
			}

			Collections.sort( al );
			
			stringBuffer = new StringBuffer();
			
			it = al.iterator();
			
			while ( it.hasNext() )
			{

				stringBuffer.append( it.next()  ).append("\r");
				
			}

			fileWriter = new FileWriter( "C:\\Users\\emman\\Documents\\Clock\\out\\list_out.txt" );
			fileWriter.write( stringBuffer.toString() );
			fileWriter.close();

		} 
		catch (IOException ioe)
		{

			System.out.println( "IO Exception : " + ioe.getMessage() );
		}

	}

}
