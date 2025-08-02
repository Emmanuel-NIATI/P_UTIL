package fr.util.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import openize.heic.decoder.HeicImage;
import openize.heic.decoder.PixelFormat;
import openize.io.IOFileStream;
import openize.io.IOMode;

public class TestPictureConvertHEIC
{

	String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
	String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
	
	// Constructeur
	public TestPictureConvertHEIC()
	{

		
	}
	
	// 1. Renommage des images
	public void renamePicture()
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

				if( "heic".equals( ext ) )
				{
						
					try
					{

						Metadata metadata = ImageMetadataReader.readMetadata(file);

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
									
									rename = "IMG_" + year + month + day + "_" + hh + mm + ss + "_" + i + ".heic"; 

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

					catch (ImageProcessingException e)
					{
					        	
						System.out.println( ">>>>>>>>>>>>>>>>>>>> ImageProcessingException : " + e.getMessage() );

					} 
					catch (IOException e)
					{

						System.out.println( ">>>>>>>>>>>>>>>>>>>> IOException : " + e.getMessage() );

					}

				}

			}

		}		
			
	}
	
	// 2. Convertion des images	
	public void convertPicture()
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
				String mininame = "";
					
				int j = name.lastIndexOf('.');

				if (j > 0)
				{
						
					ext = name.substring(j+1);
					mininame = name.substring(0, j);
					
					System.out.println( ">>>>>>>>>>>>>>>>>>>> ext : " + ext );
					System.out.println( ">>>>>>>>>>>>>>>>>>>> mininame : " + mininame );

					System.out.println( ">>>>>>>>>>>>>>>>>>>> file : " + file.getAbsolutePath() );
					
					if( "heic".equals( ext ) )
					{

						try
						{

							IOFileStream fs = new IOFileStream(file, IOMode.READ);	

						    HeicImage image = HeicImage.load(fs);
    
						    
						    int[] pixels = image.getInt32Array(PixelFormat.Argb32);
						    						    
						    int width = (int) image.getWidth();
						    int height = (int) image.getHeight();

							BufferedImage image2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
							
						
							
							
							//image2.setRGB(startX, startY, scansize);
							
							
							image2.setRGB(0, 0, width, height, pixels, 0, width);
							
							File fileOut = new File( pathOut + "\\" + mininame + ".jpg");
							
							ImageIO.write( image2, "jpg", fileOut );

							System.out.println( ">>>>>>>>>>>>>>>>>>>> fileOut : " + fileOut.getAbsolutePath() );	
							
						}
						catch (IllegalArgumentException iae)
						{

							System.out.println( ">>>>>>>>>>>>>>>>>>>> IllegalArgumentException : " + iae.getMessage() );

						}
						catch (IOException e)
						{

							System.out.println( ">>>>>>>>>>>>>>>>>>>> IOException : " + e.getMessage() );

						}
						
					}
					
				}

			}

		}		
		
	}

	public static void main(String[] args)
	{
		
		// Initialisation de la classe 
		TestPictureConvertHEIC testPictureConvertHEIC = new TestPictureConvertHEIC();
		
		// 1. Renommage des images
		// testPictureConvertHEIC.renamePicture();

		// 2. Convertion des images
		testPictureConvertHEIC.convertPicture();
		
	}

}
