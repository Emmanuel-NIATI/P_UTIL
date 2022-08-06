package fr.util.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TestImageResize
{

	public static void main(String[] args)
	{

		try
		{

			String pathIn = "C:\\Users\\emman\\eclipse-working\\in"; 
			String pathOut = "C:\\Users\\emman\\eclipse-working\\out";

			File fileIn = new File( pathIn ); 

			File[] files = fileIn.listFiles();
			File file;

			ArrayList<File> arrayListFile = new ArrayList<File>();

			for(int i = 0; i < files.length; i++ )
			{

				file = files[i];

				if( file.isFile() )
				{

					String ext = "dtc";
					String name = file.getName();

					int j = name.lastIndexOf('.');

					if (j > 0)
					{
					    ext = name.substring(j+1);
					}

					if( "png".equals( ext ) )
					{
						arrayListFile.add(file);
					}

				}

			}

			
			// Génération des fichiers de taille 2
			
			for( File f : arrayListFile )
			{
		
				System.out.println( "Fichier : " + f.getName() );
				System.out.println( "" );
				
				BufferedImage bufferedImageOriginal = ImageIO.read( f );

				int widthOriginal = bufferedImageOriginal.getWidth();
				int heightOriginal = bufferedImageOriginal.getHeight();
				
				int type = bufferedImageOriginal.getType();
				
				String fileName = f.getName();
				int indexEnd = fileName.indexOf('.');
				String fileNameSubExt = fileName.substring(0, indexEnd);

				int size2 = 2;

				int widthSized2 = widthOriginal / size2;
				int heightSized2 = heightOriginal / size2;

				BufferedImage bufferedImageSized2 = new BufferedImage(widthSized2, heightSized2, type);

				for (int ho = 0; ho < heightOriginal; ho++)
				{

					for (int hv = 0; hv < size2; hv++)
					{

						for (int wo = 0; wo < widthOriginal; wo++)
						{

							for (int wv = 0; wv < size2; wv++)
							{

								int ws = wo * size2 + wv;
								int hs = ho * size2 + hv;
								
								bufferedImageSized2.setRGB( ws, hs, bufferedImageOriginal.getRGB( wo, ho) );

							}

						}

					}

				}
				
				String strWidthSized2 = "" + widthSized2;
				
				if( strWidthSized2.length() == 1 )
				{
					strWidthSized2 = "00" + strWidthSized2;
				}
				else if( strWidthSized2.length() == 2 )
				{
					strWidthSized2 = "0" + strWidthSized2;
				}
				
				String strHeightSized2 = "" + heightSized2;

				if( strHeightSized2.length() == 1 )
				{
					strHeightSized2 = "00" + strHeightSized2;
				}
				else if( strHeightSized2.length() == 2 )
				{
					strHeightSized2 = "0" + strHeightSized2;
				}
				
				ImageIO.write( bufferedImageSized2, "png", new File( pathOut + "\\" + fileNameSubExt + "_" + strWidthSized2 + "x" + strHeightSized2 + ".png" ) );

			}
			
			System.out.println( "" );

			System.out.println("Image Successfully Manipulated!");

		}
		catch(IOException ioe)
		{
			
			System.out.println("IOException : " + ioe.getMessage() );
		}

	}

}
