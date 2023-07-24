package fr.util.test;

import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class TestMetaData
{

    void indent(int level)
    {

        for (int i = 0; i < level; i++)
        {
        	System.out.print("    ");
        }

    }
	
    void displayMetadata(Node node, int level) 
    {

        // print open tag of element
        indent(level);
        
        System.out.print("<" + node.getNodeName());
        
        NamedNodeMap map = node.getAttributes();
        
        if (map != null)
        {

        	// print attribute values
            int length = map.getLength();
            
            for (int i = 0; i < length; i++)
            {
            	
                Node attr = map.item(i);
                System.out.print(" " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"");

            }
        }

        Node child = node.getFirstChild();
        
        if (child == null)
        {

            // no children, so close element and return
            System.out.println("/>");
            return;

        }

        // children, so close current tag
        System.out.println(">");
        
        while (child != null)
        {
        	
            // print children recursively
            displayMetadata(child, level + 1);
            child = child.getNextSibling();
            
        }

        // print close tag of element
        indent(level);
        System.out.println("</" + node.getNodeName() + ">");

    }
	
    void displayMetadata(Node root)
    {
        displayMetadata(root, 0);
    }

	void readAndDisplayMetadata()
	{
		
		try
		{
			
			File file = new File("C:\\Users\\emman\\eclipse-working\\in\\IMG_20150810_184046.jpg");
			
			ImageInputStream iis = ImageIO.createImageInputStream(file);
	        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

	        if (readers.hasNext())
	        {

	        	// pick the first available ImageReader
	            ImageReader reader = readers.next();
	            
	            // attach source to the reader
	            reader.setInput(iis, true);
	            
	            IIOMetadata streamMetadata = reader.getStreamMetadata();
	                        
	            
	            
	            // read metadata of first image
	            IIOMetadata metadata = reader.getImageMetadata(0);

	            String[] names = metadata.getMetadataFormatNames();
	            
	            int length = names.length;
	            
	            for (int i = 0; i < length; i++)
	            {
	            	
	            	System.out.println( "Format name: " + names[ i ] );
	            	displayMetadata(metadata.getAsTree(names[i]));
	            }
	            
	        }
	        
		}
	    catch (Exception e)
		{

	            
		}
	}

	public static void main(String[] args)
	{

		TestMetaData testMetaData = new TestMetaData();

		testMetaData.readAndDisplayMetadata();

	}

}
