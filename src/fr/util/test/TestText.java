package fr.util.test;

import java.awt.GridBagConstraints;
import java.io.FileWriter;
import java.io.IOException;

public class TestText
{

	public static String fileOut = "C:\\Users\\emman\\eclipse-working\\out\\monFichier.txt";
	
	public static void main(String[] args)
	{

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

}
