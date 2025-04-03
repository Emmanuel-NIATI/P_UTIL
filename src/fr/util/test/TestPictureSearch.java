package fr.util.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class TestPictureSearch
{

	String pathIn2006 = "C:\\Users\\emman\\Transit\\in\\A trier\\IMG\\01\\2006";
	
	String pathSearch = "D:\\28 - Images\\01 - Album photo";
	
	
	// Constructeur
	public TestPictureSearch()
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
	
	
	
	// MyFilenameFilter class implements FilenameFilter 
	class MyFilenameFilter implements FilenameFilter
	{

		String initials; 

	    // constructor to initialize object 
	    public MyFilenameFilter(String initials) 
	    { 
	        this.initials = initials; 
	    } 
	    
	    // overriding the accept method of FilenameFilter 
	    // interface 
	    public boolean accept(File dir, String name) 
	    { 
	        return name.startsWith(initials); 
	    }
	    
	} 

	
	
	
	// Analyse du répertoire in 2006
	public void analysePathIn2006()
	{

		
		File fileIn = new File( pathIn2006 );
			
		File[] files = fileIn.listFiles();
			
		File directory = new File( pathSearch ); 
		
		for(int i = 0; i < files.length; i++ )
		{

			File file = files[i];
			
			if( file.isFile() )
			{

				System.out.println(file.getName()); 
				
				MyFilenameFilter filter = new MyFilenameFilter(file.getName());
				
				// store all names with same name  
		        // with/without extension 
		        String[] flist = directory.list(filter); 
		  
		        // Empty array 
		        if (flist == null) { 
		            System.out.println( 
		                "Empty directory or directory does not exists."); 
		        } 
		        else { 
		  
		            // Print all files with same name in directory 
		            // as provided in object of MyFilenameFilter 
		            // class 
		            for (int j = 0; i < flist.length; i++) { 
		                System.out.println(flist[j]+" found"); 
		            } 
		        } 
				
				
				
				
			}

		}		
			
	}
	
	public static void main(String[] args)
	{
		
		// 0. Initialisation de la classe 
		TestPictureSearch test = new TestPictureSearch();

		// 1. Analyse du répertoire in 2006
		test.analysePathIn2006();

		
		
		
	}

}
