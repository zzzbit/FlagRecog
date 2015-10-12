import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.applet.*;

import javax.imageio.ImageIO;

public class Test{

	/**
	 * @param args
	 */
//	public BufferedImage[]	imarray;
//	public FqImage[]		imharray	=	new FqImage[20];
	
	public static void main(String[] args) {

		
		try{
//			BufferedImage im	=	ImageIO.read(new File("d:\\image\\e.jpg"));
//			FqImage	imh			=	new FqImage(im);
//			BufferedImage im2	=	ImageIO.read(new File("d:\\image\\b1.jpg"));	
//			FqImage imh2	=	new FqImage(im2);

			
//			BufferedImage[]	imarray		=	new BufferedImage[10000];
//			FqImage[]		imharray	=	new FqImage[10000];
			
			
			 
			for( int i = 749 ; i <= 1000 ; i++ ){
				BufferedImage	im	=	ImageIO.read( new File("d:\\macro\\" + i + ".jpg") );
				FqImage			imh	=	new FqImage(im);
				System.out.print(i+" ");
				for( int j = 1 ; j <= 7 ; j++ ){
					System.out.print(imh.huJu[j]+" ");
				}
				for( int j = 1 ; j <= 3 ; j++ ){
					System.out.print(imh.colorJuH[j]+" ");
					System.out.print(imh.colorJuS[j]+" ");
					System.out.print(imh.colorJuV[j]+" ");
				}
				System.out.println();
			}
			
			
			
//			for( int i = 1 ; i <= 10 ; i++ ){
//				System.out.print(  i + " " );
//				System.out.println( imharray[2].cutSmallest().dColorJu(imharray[i].cutSmallest()));
//			}
			
			
//			System.out.println(imh.height);	System.out.println(imh.width);	System.out.println();
		
//			printRGB(imh);
//			printAlpha(imh);  
//			printRed(imh);	
//			printGreen(imh);	
//			printBlue(imh);
		
//			printGray(imh);	
//			printHHSV(imh.cutSmallest());
//			printSHSV(imh);
//			printVHSV(imh);
//			System.out.println(imh.absDistance(imh2));
//			printSobel(imh);
//			printEdge(imh);
//			printEdgeToPic(imharray[3]);
//			printSmallestToPic(imh);
//			printColorJu(imh);	System.out.println();
//			printColorJu(imh2);	System.out.println();
//			System.out.println(imh.cutSmallest().dColorJu(imh2.cutSmallest()));
//			printHuJu(imh);
//			System.out.println( imh.dHuJu(imh2) );



//			try{
//				PrintWriter out	=	new PrintWriter( new BufferedWriter( new FileWriter("iodemo.txt") ) );
//				out.print("abc");
//				out.close();
//			}catch(EOFException e){
//				System.err.println("end of str");
//			}

			
			
		
		
		
		}catch( Exception e ){
			e.printStackTrace();
		}
		


	}
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void printGray(FqImage imh){
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("g"+imh.points[i][j].getGray() );
			}
			System.out.println();
		}
		
	}
	
	public static void printRGB(FqImage imh){
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("rgb"+imh.points[i][j].getRGB() );
			}
			System.out.println();
		}
		
	}
	
	public static void printHHSV(FqImage imh){
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("h"+imh.points[i][j].getHHSV() );
			}
			System.out.println();
		}
		
	}
	
	public static void printSHSV(FqImage imh){
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("s"+imh.points[i][j].getSHSV() );
			}
			System.out.println();
		}
		
	}
	
	public static void printVHSV(FqImage imh){
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("v"+imh.points[i][j].getVHSV() );
			}
			System.out.println();
		}
		
	}
	
	public static void printAlpha(FqImage imh) {
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("a"+imh.points[i][j].getAlpha()+"a");
			}
			System.out.println();
		}
		
	}
	
	public static void printRed(FqImage imh) {
		// TODO Auto-generated method stub
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("r"+imh.points[i][j].getRed()+"r");
			}
			System.out.println();
		}
		
	}
	
	public static void printGreen(FqImage imh){
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("g"+imh.points[i][j].getGreen()+"g");
			}
			System.out.println();
		}
	}
	
	public static void printBlue(FqImage imh){
		int	i,j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print("b"+imh.points[i][j].getBlue()+"b");
			}
			System.out.println();
		}
	}
	
	public static void printSobel( FqImage imh ){
		int i , j;
		for( i =  0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				System.out.print( "s" + imh.sobels[i][j] );
			}
			System.out.println();
		}
	}
	
	public static void printEdge( FqImage imh ){
		int i , j;
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				if( imh.edge[i][j] == 1 )
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void printEdgeToPic( FqImage imh ){
		int	i , j;
		BufferedImage	newImh	=	new BufferedImage( imh.width , imh.height , 1 );
		for( i = 0 ; i < imh.width ; i++ ){
			for( j = 0 ; j < imh.height ; j++ ){
				if( imh.edge[i][j] == 1 )
					newImh.setRGB(i, j, 0xFFF);
				else
					newImh.setRGB(i, j, 0x00);
			}
		}
		try {
			ImageIO.write(newImh, "JPEG", new File("d:\\image\\edge.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printSmallestToPic( FqImage imh ){
		FqImage subImh	=	imh.cutSmallest();
		try {
			ImageIO.write(subImh.imh, "JPEG", new File("d:\\image\\small.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printColorJu( FqImage imh ){
		for( int i = 1 ; i <= 3 ; i++ ){
			System.out.println( imh.colorJuH[i] + "," + imh.colorJuS[i] + "," + imh.colorJuV[i] );
		}
	}
	
	public static void printHuJu( FqImage imh ){
		for( int i = 1 ; i <= 7 ; i++ )
			System.out.print(imh.huJu[i]+"  ");
		System.out.println();
	}

}
