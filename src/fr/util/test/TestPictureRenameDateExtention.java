package fr.util.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class TestPictureRenameDateExtention
{

	String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
	String pathOut = "C:\\Users\\emman\\eclipse-working\\out";

	// Constructeur
	public TestPictureRenameDateExtention()
	{

	}

	private String toThreeDigits( int cpt )
	{
		
		String s_cpt = String.valueOf(cpt);
		
		if(s_cpt.length() == 1 )
		{
			
			s_cpt = "00" + s_cpt;
			
		}
		else if(s_cpt.length() == 2 )
		{
			s_cpt = "0" + s_cpt;
		}
		else
		{
			s_cpt = s_cpt;
		}
		
		return s_cpt;
		
	}
	
	// Analyse du répertoire in
	public void analysePathIn()
	{

		File fileIn = new File( pathIn );
			
		File[] files = fileIn.listFiles();
			
		for(int i = 0; i < files.length; i++ )
		{

			File file = files[i];
			
			if( file.isFile() )
			{

				String ext = "";
				String name = file.getName();
				String rename = "";
					
				int j = name.lastIndexOf('.');

				if (j > 0)
				{
						
					ext = name.substring(j+1);
				}

				if( "jpg".equals( ext ) || "JPG".equals( ext ) )
				{
						
					try
					{

						Metadata metadata = JpegMetadataReader.readMetadata(file);

						for (Directory directory : metadata.getDirectories())
						{
						        
							for (Tag tag : directory.getTags())
							{

								if( "Date/Time Original".equals( tag.getTagName() ) )
								{

									String date = tag.getDescription();
										
									String year = date.substring(0, 4);
									String month = date.substring(5, 7);
									String day = date.substring(8, 10);
										
									String hh = date.substring(11, 13);
									String mm = date.substring(14, 16);
									String ss = date.substring(17, 19);

									rename = "IMG_" + year + month + day + "_" + hh + mm + ss + ".jpg"; 

									System.out.print( name + " / " + rename + " / " );
									
									if( name.equals( rename ) )
									{

										System.out.println( "OK !" );
											
									}
									else
									{
											
										System.out.println( "Warning !!!" );
											
									}
										
									file.renameTo( new File( pathOut + "\\" +  rename ) );						

								}
								
							}

						}

					}

					catch (JpegProcessingException e)
					{
					        	
						System.out.println( ">>>>>>>>>>>>>>>>>>>> JpegProcessingException : " + e.getMessage() );

					} 
					catch (IOException e)
					{

						System.out.println( ">>>>>>>>>>>>>>>>>>>> IOException : " + e.getMessage() );

					}

				}

			}

		}		
			
	}
	
	public static void main(String[] args)
	{
		
		// 0. Initialisation de la classe 
		TestPictureRenameDateExtention test = new TestPictureRenameDateExtention();

		// 1. Analyse du répertoire in 
		test.analysePathIn();

		
		
		
	}

}
