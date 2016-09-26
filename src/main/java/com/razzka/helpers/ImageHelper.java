package com.razzka.helpers;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class ImageHelper {
	public static BufferedImage cutWeapon(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(
        		174, 176, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g1 = newImage.createGraphics();
        g1.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 174, 176); 

        Area circle = new Area(ellipse);

        g1.setClip(circle);
        g1.drawImage(image, -70, -80, null);
        
        g1.dispose();
        
        return newImage;
	}
	
	public static BufferedImage cutMinion(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(
        		174, 176, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g1 = newImage.createGraphics();
        g1.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 155, 200); 

        Area circle = new Area(ellipse);

        g1.setClip(circle);
        g1.drawImage(image, -76, -74, null);
        
        g1.dispose();
        
        return newImage;
	}
    
	public static BufferedImage cutHeroPower(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(
        		118, 116, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g1 = newImage.createGraphics();
        g1.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 118, 116); 

        Area circle = new Area(ellipse);

        g1.setClip(circle);
        g1.drawImage(image, -95, -95, null);
        
        g1.dispose();
        
        return newImage;
	}
	
	public static void cutGifWeapon(String imageUrl, String destinationFile) throws IOException {
	    URL url = new URL(imageUrl);

	    InputStream is = url.openStream();
	    
	    ImageFrame[] frames = ImageFrame.readGif( is );
	    for (int i = 0; i < frames.length; i++){
	         BufferedImage image = ImageHelper.cutWeapon(frames[i].getImage());
	         frames[i].setImage(image);
	    }
	    
	    ImageOutputStream output =
	    	       new FileImageOutputStream(new File(destinationFile));

	    GifSequenceWriter writer =
	        new GifSequenceWriter(output, frames[0].getImage().getType(), frames[0].getDelay(), true);
	
	    writer.writeToSequence(frames[0].getImage());
	    for (int i = 1; i < frames.length; i++) {
	        BufferedImage nextImage = frames[i].getImage();
	        writer.writeToSequence( nextImage );
	    }
	
	    writer.close();
	    output.close();
	}
	
	public static void cutGifHeropower(String imageUrl, String destinationFile) throws IOException {
	    URL url = new URL(imageUrl);

	    InputStream is = url.openStream();
	    
	    ImageFrame[] frames = ImageFrame.readGif( is );
	    for (int i = 0; i < frames.length; i++){
	         BufferedImage image = ImageHelper.cutHeroPower(frames[i].getImage());
	         frames[i].setImage(image);
	    }
	    
	    ImageOutputStream output =
	    	       new FileImageOutputStream(new File(destinationFile));

	    GifSequenceWriter writer =
	        new GifSequenceWriter(output, frames[0].getImage().getType(), frames[0].getDelay(), true);
	
	    writer.writeToSequence(frames[0].getImage());
	    for (int i = 1; i < frames.length; i++) {
	        BufferedImage nextImage = frames[i].getImage();
	        writer.writeToSequence( nextImage );
	    }
	
	    writer.close();
	    output.close();
	}
	
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
	    URL url = new URL(imageUrl);
	    InputStream is = url.openStream();
	    File file = new File(destinationFile);
	    file.getParentFile().mkdirs();
	    file.createNewFile();
	    OutputStream os = new FileOutputStream(destinationFile );

	    byte[] b = new byte[2048];
	    int length;

	    while ((length = is.read(b)) != -1) {
	        os.write(b, 0, length);
	    }

	    is.close();
	    os.close();
	}
}