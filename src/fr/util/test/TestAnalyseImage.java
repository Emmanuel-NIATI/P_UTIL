package fr.util.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TestAnalyseImage
{

	public static void main(String[] args)
	{
		
		try
		{
			
			String pathIn = "C:\\Users\\emman\\eclipse-working\\in"; 
			
			File fileIn = new File( pathIn ); 

			File[] filesIn = fileIn.listFiles();
			File fIn;

			ArrayList<File> arrayListFileIn = new ArrayList<File>();

			for(int i = 0; i < filesIn.length; i++ )
			{
				
				fIn = filesIn[i];
				
				if( fIn.isFile() )
				{
					
					String ext = "dtc";
					String name = fIn.getName();
					
					int j = name.lastIndexOf('.');
					
					if (j > 0)
					{

					    ext = name.substring(j+1);
					}
					
					if( "png".equals( ext ) )
					{

						arrayListFileIn.add(fIn);
					}
				
					
				}
				
			}
			
			// Génération des fichiers en transparence
			
			for( File f : arrayListFileIn )
			{
		
				System.out.println( "Fichier : " + f.getName() );
				
				if( "letter_A.png".equals( f.getName() ) )
				{
					
					
					
					
					BufferedImage bufferedImageOriginal = ImageIO.read( f );
					
					if( bufferedImageOriginal.getType() == BufferedImage.TYPE_4BYTE_ABGR )
					{
					
						System.out.println( "type : " + "TYPE_4BYTE_ABGR" );
						
					}
					
					//	Represents an image with 8-bit RGBA color components with the colors Blue, Green, and Red stored in 3 bytes and 1 byte of alpha.
					//	The image has a {@code ComponentColorModel} with alpha. The color data in this image is considered not to be premultiplied with
					//	alpha. The byte data is interleaved in a single byte array in the order A, B, G, R from lower to higher byte addresses within each pixel.

					System.out.println( "" );

					int widthOriginal = bufferedImageOriginal.getWidth();
					int heightOriginal = bufferedImageOriginal.getHeight();
				
					for( int c = 0; c < widthOriginal; c++ )
					{

						for( int l = 0; l < heightOriginal; l++ )
						{
							
							int rgb = bufferedImageOriginal.getRGB(c, l);
							
							System.out.println( "color : " + rgb  );

						}

					}

					
					
				}
				
				
				
				
				
				
				
				
				
				
				
			}

			System.out.println( "" );
			
			System.out.println("Image successfully read !");

		}
		catch(IOException ioe)
		{
			
			System.out.println("IOException : " + ioe.getMessage() );
		}
		
	}

}
