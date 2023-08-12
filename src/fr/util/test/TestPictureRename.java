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
import com.drew.imaging.mp4.Mp4MetadataReader;

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
									
									rename = "IMG_" + year + month + day + "_" + hh + mm + ss; 

									arrayListNameFile.add( name );
									arrayListRenameFile.add( rename );

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
		
		int cpt = 1;
		
		for(String s : arrayListRenameFile )
		{

			int freq = Collections.frequency(arrayListRenameFile, s);

			String n = arrayListNameFile.get(arrayListRenameFile.indexOf(s));
			
			String s_cpt = toThreeDigits(cpt);
			
			System.out.print( s_cpt + " " + s + " " + freq + " " + n );

			if( freq == 2 )
			{

				String r = arrayListNameFile.get(arrayListRenameFile.lastIndexOf(s));	
				
				System.out.println( " " + r + " !!!");	

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
		
		File file = new File("D:\\00 - Personnel\\02 - Secret\\Vidéo\\production\\Personnel - 2017-03-21\\rush\\Personnel - 2017-03-21.mp4");
		
        try
        {
        	// Metadata metadata = JpegMetadataReader.readMetadata(file);

        	Metadata metadata = Mp4MetadataReader.readMetadata(file);
        	
        	afficheMetaData(metadata, "Using Mp4MetadataReader");
        } 
        /*
        catch (JpegProcessingException e)
        {
        	
        	System.out.println(e.getMessage());

        }
        */        
        catch (IOException e)
        {

        	System.out.println(e.getMessage());

        }
		
	}

	
	public void renameByFileName()
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

					rename = "IMG_" + name; 
					
					arrayListRenameFile.add(rename);
					
					System.out.print( name );
					System.out.print( " -> " );
					System.out.print( rename );
					System.out.println( "" );
					
					file.renameTo( new File( pathOut + "\\" +  rename ) );

				}
				
			}

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
									
									rename = "IMG_" + year + month + day + "_" + hh + mm + ss; 
									
									arrayListRenameFile.add(rename);
									
									file.renameTo( new File( pathOut + "\\" +  rename + ".jpg") );
									
								}

							}

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

		// 4. Renommage des photos par le nom du fichier
		test.renameByFileName();
		
		// 5. Renommage des photos
		// test.rename();

	}

}
