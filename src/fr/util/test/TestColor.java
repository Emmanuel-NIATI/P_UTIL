package fr.util.test;

public class TestColor
{

	public TestColor()
	{
		
	}
		
    private int RGB888ToRGB565(short r8, short g8, short b8)
    {

    	short r5 = (short)((r8 * 249 + 1014) >> 11);
    	short g6 = (short)((g8 * 253 + 505) >> 10);
    	short b5 = (short)((b8 * 249 + 1014) >> 11);

        return (r5 << 11 | g6 << 5 | b5);

    }
	
	public static void main(String[] args)
	{

		TestColor unTestColor = new TestColor();
				
		
	 	// public final static int COLOR_BLACK			= 0x0000;  //   0,   0,   0
		int c01 = unTestColor.RGB888ToRGB565((short) 0, (short) 0, (short) 0);

		// public final static int COLOR_NAVY       	= 0x000F;  //   0,   0, 123
		int c02 = unTestColor.RGB888ToRGB565((short) 0, (short) 0, (short) 123);
		System.out.print( "COLOR_NAVY : " );
		System.out.println( Integer.toHexString( c02 ).toUpperCase() );
		
		// public final static int COLOR_DARKGREEN  	= 0x03E0;  //   0, 125,   0
	 	// public final static int COLOR_DARKCYAN   	= 0x03EF;  //   0, 125, 123
	 	// public final static int COLOR_MAROON     	= 0x7800;  // 123,   0,   0
	 	// public final static int COLOR_PURPLE     	= 0x780F;  // 123,   0, 123
	 	// public final static int COLOR_OLIVE      	= 0x7BE0;  // 123, 125,   0
	 	// public final static int COLOR_LIGHTGREY		= 0xC618;  // 198, 195, 198
	 	// public final static int COLOR_DARKGREY   	= 0x7BEF;  // 123, 125, 123
	 	// public final static int COLOR_BLUE       	= 0x001F;  //   0,   0, 255
	 	// public final static int COLOR_GREEN       	= 0x07E0;  //   0, 255,   0
	 	// public final static int COLOR_CYAN        	= 0x07FF;  //   0, 255, 255
	 	// public final static int COLOR_RED         	= 0xF800;  // 255,   0,   0
	 	
		// public final static int COLOR_MAGENTA     	= 0xF81F;  // 255,   0, 255
		int c14 = unTestColor.RGB888ToRGB565((short) 255, (short) 0, (short) 255);
		System.out.print( "COLOR_MAGENTA : " );
		System.out.println( Integer.toHexString( c14 ).toUpperCase() );

		
		
	 	// public final static int COLOR_YELLOW      	= 0xFFE0;  // 255, 255,   0
	 	// public final static int COLOR_WHITE       	= 0xFFFF;  // 255, 255, 255
	 	// public final static int COLOR_ORANGE      	= 0xFD20;  // 255, 165,   0
		
		
		
		
	 	// public final static int COLOR_GREENYELLOW	= 0xAFE5;  // 173, 255,  41
		
		// public final static int COLOR_PINK			= 0xFC18;  // 255, 130, 198
		int c19 = unTestColor.RGB888ToRGB565((short) 255, (short) 130, (short) 198);
		System.out.print( "COLOR_PINK : " );
		System.out.println( Integer.toHexString( c19 ).toUpperCase() );

		// public final static int COLOR_PINK_PAULINE	= 0xFC18;  // 255, 165, 198
		int c20 = unTestColor.RGB888ToRGB565((short) 255, (short) 165, (short) 198);
		System.out.print( "COLOR_PINK_PAULINE : " );
		System.out.println( Integer.toHexString( c20 ).toUpperCase() );
		
		System.out.println("---------------------------------------------------");

		int y1 = 120;
		
		int y11 = (y1 >> 8) & 0xFF;
		System.out.println( "" + y11  );
		
		int y12 = y1 & 0xFF;
		System.out.println( "" + y12 );
		
		
		
		System.out.println("---------------------------------------------------");
		
		int color = 0xFC18;
		
		int b1 = (color >> 8) & 0xFF;
		System.out.println( Integer.toHexString( b1 ).toUpperCase() );
		
		int b2 = color & 0xFF;
		System.out.println( Integer.toHexString( b2 ).toUpperCase() );
	
		
		
		
		
		
	}

}
