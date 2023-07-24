package fr.util.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.iptc.IptcReader;

public class TestPictureRename
{

	String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
	String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
	
	// Constructeur
	public TestPictureRename()
	{

	}
	
	// Analyse du répertoire
	public void analyse()
	{
	
		File fileIn = new File( pathIn ); 

		File[] files = fileIn.listFiles();

		ArrayList<File> arrayListFile = new ArrayList<File>();

		ArrayList<String> arrayListNameFile = new ArrayList<String>();
		ArrayList<String> arrayListRenameFile = new ArrayList<String>();

		for(int i = 0; i < files.length; i++ )
		{

			File file = files[i];

			arrayListFile.add(file);

		}
		
		Iterator<File> iteratorFile = arrayListFile.iterator();

		while ( iteratorFile.hasNext() )
		{

			File file = iteratorFile.next();
			
			if( file.isFile() )
			{

				String ext = "jpg";
				String name = file.getName();
				String rename = "";
				
				int j = name.lastIndexOf('.');

				if (j > 0)
				{
					
				    ext = name.substring(j+1);
				}

				if( "jpg".equals( ext ) || "JPG".equals( ext ) )
				{
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
					Date d = new Date(file.lastModified());

					rename = "IMG_" + sdf.format(d);

					arrayListNameFile.add( name );
			
					arrayListRenameFile.add( rename );

				}

			}

		}
		
		int cpt = 0;
		
		for(String s : arrayListRenameFile )
		{

			int freq = Collections.frequency(arrayListRenameFile, s);

			String n = arrayListNameFile.get(arrayListRenameFile.indexOf(s));
			
			System.out.print( cpt + " " + s + " " + freq + " " + n );

			if( freq == 2 )
			{

				String l = arrayListNameFile.get(arrayListRenameFile.lastIndexOf(s));	
				
				System.out.println( " " + l );	

			}
			else
			{
				
				System.out.println();

			}

			cpt++;

		}

	}
	
	public void modifyProperties()
	{
	
		
		File file = new File( "C:\\Users\\emman\\eclipse-working\\in\\DSC_8824.JPG" );
		
		long fd = file.lastModified();
		
		fd = fd + 1000;

		file.setLastModified(fd);
		
		file.renameTo(new File( "C:\\Users\\emman\\eclipse-working\\out\\DSC_8824.JPG" ));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		Date date = new Date(fd); 

		System.out.println( sdf.format(date) );
		

	}
	
	private void afficheMetaData(Metadata metadata, String method)
	{

		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.print(' ');
		System.out.print(method);
		System.out.println("-------------------------------------------------");
		System.out.println();

		for (Directory directory : metadata.getDirectories())
		{

			//
			// Each Directory stores values in Tag objects
			//
	        
			for (Tag tag : directory.getTags())
			{
				
				System.out.println(tag);

			}

			//
			// Each Directory may also contain error messages
			//
			for (String error : directory.getErrors())
			{
				
				System.err.println("ERROR: " + error);

			}

        }

	}

	public void properties()
	{
		
		File file = new File("C:\\Users\\emman\\eclipse-working\\in\\IMG_20150810_184046.jpg");
		
        try
        {
        	Metadata metadata = JpegMetadataReader.readMetadata(file);

        	afficheMetaData(metadata, "Using JpegMetadataReader");
        } 
        catch (JpegProcessingException e)
        {
        	
        	System.out.println(e.getMessage());

        } 
        catch (IOException e)
        {

        	System.out.println(e.getMessage());

        }
		
	}

	public void rename()
	{

		File fileIn = new File( pathIn ); 

		File[] files = fileIn.listFiles();

		ArrayList<File> arrayListFile = new ArrayList<File>();
		ArrayList<String> arrayListNameFile = new ArrayList<String>();
		ArrayList<String> arrayListRenameFile = new ArrayList<String>();
		
		for(int i = 0; i < files.length; i++ )
		{

			File file = files[i];

			arrayListNameFile.add(file.getName());
			
			arrayListFile.add(file);

		}
		
		Iterator<File> iteratorFile = arrayListFile.iterator();
		
		while ( iteratorFile.hasNext() )
		{

			File file = iteratorFile.next();
			
			if( file.isFile() )
			{

				String ext = "jpg";
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
						
						System.out.println( "" );
						System.out.println( "File Name : " + file.getName() );

						Metadata metadata = JpegMetadataReader.readMetadata(file);
						
						for (Directory directory : metadata.getDirectories())
						{

							
							// System.out.println(directory);
							
							//
							// Each Directory stores values in Tag objects
							//
					        
							for (Tag tag : directory.getTags())
							{

								if( "Date/Time Original".equals( tag.getTagName() ) )
								{

									System.out.print( tag.getTagName() );
									System.out.print( " : " );
									System.out.print( tag.getDescription() );
									System.out.println( "" );
									
									String date = tag.getDescription();
									
									String year = date.substring(0, 4);
									String month = date.substring(5, 7);
									String day = date.substring(8, 10);
									
									String hh = date.substring(11, 13);
									String mm = date.substring(14, 16);
									String ss = date.substring(17, 19);
									
									System.out.println( "date : " + date );
									
									System.out.println( "year : " + year );
									System.out.println( "month : " + month );
									System.out.println( "day : " + day );
									
									System.out.println( "hh : " + hh );
									System.out.println( "mm : " + mm );
									System.out.println( "ss : " + ss );
									
									rename = year + month + day + "_" + hh + mm + ss; 
									
									System.out.println( "rename : " + rename );
									
									arrayListRenameFile.add(rename);
									
									file.renameTo( new File( pathOut + "\\" +  "IMG_" + rename + ".jpg") );
									
								}

							}

							//
							// Each Directory may also contain error messages
							//
							for (String error : directory.getErrors())
							{
								
								System.err.println("ERROR: " + error);

							}

				        }

				    } 
					catch (JpegProcessingException e)
				    {
				        	
						System.out.println(e.getMessage());

				    } 
				    catch (IOException e)
				    {

				    	System.out.println(e.getMessage());

				    }

				}

			}

		}

	}

	public static void main(String[] args)
	{

		// Initialisation de la classe 
		TestPictureRename test = new TestPictureRename();

		// 1. Analyse du répertoire
		// test.analyse();

		// 2. Modification des propriétés d'un fichier
		// test.modifyProperties();

		// 3. Recherche des date du fichiers
		// test.properties();

		// 4. Renommage des photos
		test.rename();

	}

}
