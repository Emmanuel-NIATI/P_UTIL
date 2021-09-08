package fr.util.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestRename
{

	public static void main(String[] args)
	{

			String pathIn = "D:\\EclipseWorking\\in"; 
			String pathOut = "D:\\EclipseWorking\\out";

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

					if( "jpg".equals( ext ) )
					{
						arrayListFile.add(file);
					}

				}

			}

			
			// Changement de nom
			
			int i = 0;
			
			for( File f : arrayListFile )
			{

				i++;
				
				String name = f.getName().substring(13);

				System.out.println( name );
				
				System.out.println( "" + i );
				
				File g = new File( pathOut + "\\" +  name );
				
		        f.renameTo( g );
				
			}

			System.out.println("Files Successfully Manipulated!");
				
				
				/*

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			    Date d = new Date(f.lastModified());
			    
			    String name = f.getName() + "_" + "IMG_" + sdf.format(d);
			    

				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_Hmmss");

				Date d = new Date( f.lastModified() );
		        
		        String name = sdf.format(d);

		        File g = new File( pathOut + "\\" +  name + ".jpg");
				
				f.renameTo( g );
				*/
				
				

	}

}
