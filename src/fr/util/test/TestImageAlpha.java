package fr.util.test;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

// RGBA (Red Green Blue Alpha) est une extension du format de codage des couleurs RGB qui lui ajoute un canal alpha qui détermine l’opacité. 
// Ppour calculer une image numérique composée de calques virtuels, superposés.
//
// A = 0 => Transparent
// A = 255 => Opaque

public class TestImageAlpha
{

	String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
	String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
	
	String fileOut = "C:\\Users\\emman\\eclipse-working\\out\\monFichier.txt";
	
	StringBuffer sb = new StringBuffer();
	
	FileWriter fichier;
	
	public TestImageAlpha()
	{
		
	}

	public void analyseImage()
	{
		
		try
		{

			File fileIn = new File( pathIn ); 

			File[] filesIn = fileIn.listFiles();
			
			sb.append( "-----------------------" ).append( "\n" );
			
			for( File f : filesIn )
			{

				if( f.isFile() )
				{
					
					String ext = "dtc";
					String name = f.getName();
					
					int j = name.lastIndexOf('.');
					
					if (j > 0)
					{

					    ext = name.substring(j+1);
					}
					
					if( "png".equals( ext ) )
					{

						sb.append( "- Fichier : " ).append( f.getName() ).append( "\n" );
						sb.append( "-" ).append( "\n" );

						BufferedImage bufferedImageOriginal = ImageIO.read( f );

						int widthOriginal = bufferedImageOriginal.getWidth();
						int heightOriginal = bufferedImageOriginal.getHeight();
						
						int type = bufferedImageOriginal.getType();

						sb.append( "- Type : " ).append( type ).append( "\n" );
						sb.append( "-" ).append( "\n" );
						
						String fileName = f.getName();
						int indexEnd = fileName.indexOf('.');
						String fileNameSubExt = fileName.substring(0, indexEnd);
						
						for( int c = 0; c < widthOriginal; c++ )
						{

							for( int l = 0; l < heightOriginal; l++ )
							{
								
								int rgb = bufferedImageOriginal.getRGB(c, l);
								
								sb.append( "- Couleur : " ).append( rgb ).append( "\n" );
								sb.append( "-" ).append( "\n" );
								
							}
							
						}

						sb.append( "-----------------------" ).append( "\n" );	

					}

				}

				fichier = new FileWriter( fileOut );
			    fichier.write ( sb.toString() );
			    fichier.close();

			}
		
		}
		catch(IOException ioe)
		{
			
			System.out.println("IOException : " + ioe.getMessage() );
			
		}
		catch(Exception e)
		{
			
			System.out.println("OException : " + e.getMessage() );

		}
		
	}
	
	public void couleurImage()
	{
		
		try
		{
			
			File fileIn = new File( pathIn ); 
			
			File[] filesIn = fileIn.listFiles();

			sb.append( "-----------------------" ).append( "\n" );
			
			for( File f : filesIn )
			{
				
				if( f.isFile() )
				{
				
					String ext = "dtc";
					String name = f.getName();
				
					int j = name.lastIndexOf('.');
				
					if (j > 0)
					{

						ext = name.substring(j+1);
					}
				
					if( "png".equals( ext ) )
					{

						sb.append( "- Fichier : " ).append( f.getName() ).append( "\n" );
						sb.append( "-" ).append( "\n" );
						
						BufferedImage bufferedImageOriginal = ImageIO.read( f );

						int widthOriginal = bufferedImageOriginal.getWidth();
						int heightOriginal = bufferedImageOriginal.getHeight();

						int type = bufferedImageOriginal.getType();

						sb.append( "- Type : " ).append( type ).append( "\n" );
						sb.append( "-" ).append( "\n" );
						
						String fileName = f.getName();
						int indexEnd = fileName.indexOf('.');
						String fileNameSubExt = fileName.substring(0, indexEnd);
					
						for( int c = 0; c < widthOriginal; c++ )
						{

							for( int l = 0; l < heightOriginal; l++ )
							{
							
								int rgb = bufferedImageOriginal.getRGB(c, l);

								sb.append( "- Couleur : " ).append( rgb ).append( "\n" );
								sb.append( "-" ).append( "\n" );
								
								if( (rgb != -1) && ( rgb != -14969267 ) )
								{

									bufferedImageOriginal.setRGB(c,  l, -1);

								}

							}
							
						}
						
						sb.append( "-----------------------" ).append( "\n" );
						
						ImageIO.write( bufferedImageOriginal, "png", new File( pathOut + "\\" + fileNameSubExt + ".png" ) );

					}
			
				}
				
				fichier = new FileWriter( fileOut );
			    fichier.write ( sb.toString() );
			    fichier.close();
			}

		}
		catch(IOException ioe)
		{
		
			System.out.println("IOException : " + ioe.getMessage() );
		
		}
		catch(Exception e)
		{
		
			System.out.println("OException : " + e.getMessage() );

		}
		
	}
	
	public void alphaImage()
	{
		
		try
		{
			
			File fileIn = new File( pathIn ); 
			
			File[] filesIn = fileIn.listFiles();

			System.out.println( "-----------------------" );
			
			for( File f : filesIn )
			{
				
				if( f.isFile() )
				{
				
					String ext = "dtc";
					String name = f.getName();
				
					int j = name.lastIndexOf('.');
				
					if (j > 0)
					{

						ext = name.substring(j+1);
					}
				
					if( "png".equals( ext ) )
					{

						System.out.println( "- Fichier : " + f.getName() );
						System.out.println( "-" );
					
						BufferedImage bufferedImageOriginal = ImageIO.read( f );

						int widthOriginal = bufferedImageOriginal.getWidth();
						int heightOriginal = bufferedImageOriginal.getHeight();

						int type = bufferedImageOriginal.getType();

						System.out.println( "- Type : " + type );
					
						String fileName = f.getName();
						int indexEnd = fileName.indexOf('.');
						String fileNameSubExt = fileName.substring(0, indexEnd);
					
						for( int c = 0; c < widthOriginal; c++ )
						{

							for( int l = 0; l < heightOriginal; l++ )
							{
							
								int rgb = bufferedImageOriginal.getRGB(c, l);
							
								System.out.println( "- Couleur : " + rgb  );

								if( rgb == -1 )
								{

									bufferedImageOriginal.setRGB(c,  l, 16777215);

								}

							}
						
						}
						
						ImageIO.write( bufferedImageOriginal, "png", new File( pathOut + "\\" + fileNameSubExt + ".png" ) );

					}
			
				}

			}

		}
		catch(IOException ioe)
		{
		
			System.out.println("IOException : " + ioe.getMessage() );
		
		}
		catch(Exception e)
		{
		
			System.out.println("OException : " + e.getMessage() );

		}
		
	}

	public static void main(String[] args)
	{

		// Initialisation de la classe
		TestImageAlpha testImageAlpha = new TestImageAlpha();

		// Analyse de chaque image
		// testImageAlpha.analyseImage();

		// Génération de chaque image avec couleur
		testImageAlpha.couleurImage();
		
		// Génération de chaque image en transparence
		// testImageAlpha.alphaImage();

	}

}
