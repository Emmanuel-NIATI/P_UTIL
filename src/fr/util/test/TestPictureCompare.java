package fr.util.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
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

public class TestPictureCompare
{

	String pathIn = "C:\\Users\\emman\\eclipse-working\\in";
	String pathOut = "C:\\Users\\emman\\eclipse-working\\out";
	
	static String pathD = "D:\\";
	
	PrintStream printStream;
	
	// Constructeur
	public TestPictureCompare()
	{

		try
		{

			// Initialisation de la console de sortie
			printStream = new PrintStream(System.out, true, "UTF-8");

		}
		catch(UnsupportedEncodingException e)
		{
			
		}
		
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
	public void analysePath()
	{
	
		File fileD = new File( pathD ); 
		
		File[] files = fileD.listFiles();

		ArrayList<File> arrayListFile = new ArrayList<File>();

		for(int i = 0; i < files.length; i++ )
		{

			File file = files[i];

			if( !file.isHidden() )
			{
			
				arrayListFile.add(file);
				
			}

		}

		printStream.println( ">>>>>>>>>> Nombre : " + arrayListFile.size() );
		
		Iterator<File> iteratorFile = arrayListFile.iterator();

		while ( iteratorFile.hasNext() )
		{

			File file = iteratorFile.next();
			
			String name = file.getName();
			
			printStream.println( ">>>>>>>>>> Name : " + name );

		}

	}

	
	
	// Affichage du répertoire d:\
	public void display(String pathD_)
	{
		
        File file;
        String list[];
        file = new File( pathD_ );
 
        if (file.isDirectory())
        {
        	
            list = file.list();
            
            for (int i = 0; i < list.length; i++)
            {

            	display( pathD_ + File.separatorChar + list[i]);

            }

        }
        else
        {
        	
        	printStream.print( file.getName() + "\n" );
        	//printStream.print( file.toString() + "\n" );

        }

	}
		
	public void createDirectory()
	{
		
		 File file;
		 
		 for(int i = 25; i < 55; i++)
		 {
		
			 file = new File( "E:\\91 - Zone\\Zone_" + i );
			 file.mkdir();
		 }
		
	}
		
	public static void main(String[] args)
	{
		
		// Initialisation de la classe 
		TestPictureCompare testCompare = new TestPictureCompare();
		
		// 1. Analyse du répertoire
		// testCompare.analysePath();

		// 2. Affichage du répertoire d:\
		// testCompare.display( pathD );

		// 3. Création de répertoire
		// testCompare.createDirectory();
		
		
	}

}
