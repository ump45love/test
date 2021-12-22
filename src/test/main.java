package test;

import java.awt.Color;
import java.awt.image.BufferedImage;

import ij.ImagePlus;
import ij.io.FileSaver;
import ij.process.ImageProcessor;

public class main {
	
	static int invert(int num) {
		if(num <85)
			return 0;
		else if(num < 170)
			return 128;
		else
			return 255;
	}
	static int image() {
		int num = 0;
		ImagePlus imgPlus = new ImagePlus("C:\\a.jpg");
		ImageProcessor imgProcessor = imgPlus.getProcessor();
		imgProcessor.invert();
		FileSaver fs = new FileSaver(imgPlus);
		BufferedImage bufferedImage = imgProcessor.getBufferedImage();
		for(int y=0;y<bufferedImage.getHeight();y++)
		{
		    for(int x=0;x<bufferedImage.getWidth();x++)
		    {
		        Color color = new Color(bufferedImage.getRGB(x, y));
		        num = invert(color.getRed())*65536 + invert(color.getGreen())*256 + invert(color.getBlue());
		        if(x == 100)
		         System.out.printf("(%x) ",num);
		        bufferedImage.setRGB(x, y, num);
		    }
		}
		ImagePlus grayImg = new ImagePlus("asd", bufferedImage);
		fs = new FileSaver(grayImg);
		fs.saveAsJpeg("C:\\Users\\·´¾»\\Desktop\\.metadata\\test.jpg");
		return num;
	}
	public static void main(String[] args) { 
		image();
		
	}

}
