package fr.util.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TestTextCodeCS
{
	
	public TestTextCodeCS()
	{
	
	}
	
	public void generatorCodeCS()
	{
		
		StringBuffer stringBuffer;
		FileWriter fileWriter;
		
		String sFileOut = "C:\\Users\\emman\\eclipse-working\\out\\TotolasticoCodeCS.txt";

		try
		{
			stringBuffer = new StringBuffer();

			
						
			/*

			 if (l_compteur > 99999)
    		{

        		d_Accumulateur_digit_00 = _l_accumulateur / XXXXXXXXXXXXX;
        		l_Accumulateur_digit_00 = (long)Math.Truncate(d_Accumulateur_digit_00);
        		_l_accumulateur = _l_accumulateur - l_Accumulateur_digit_00 * XXXXXXXXX;
    		}

			 * 
			 */

			
			
			for(int i=10; i>=0; i--)
			{
				
				stringBuffer.append("if(l_compteur > (Math.Pow(10, ").append(i).append(")-1))").append("\r");
				stringBuffer.append("{").append("\r");
				
				
				stringBuffer.append("d_Accumulateur_digit_0").append(i).append(" = _l_accumulateur / Math.Pow(10, ").append(i).append(");").append("\r");
				stringBuffer.append("d_Accumulateur_digit_0").append(i).append(" = (long)Math.Truncate(d_Accumulateur_digit_0").append(i).append(");").append("\r");    
				stringBuffer.append("_l_accumulateur = _l_accumulateur - l_Accumulateur_digit_0").append(i).append(" * Math.Pow(10, ").append(i).append(");").append("\r");
								
				
				
				stringBuffer.append("\r");
				stringBuffer.append("}").append("\r");
				stringBuffer.append("\r");
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

		TestTextCodeCS testTextCodeCS = new TestTextCodeCS();
		
		testTextCodeCS.generatorCodeCS();
		
	}

}
