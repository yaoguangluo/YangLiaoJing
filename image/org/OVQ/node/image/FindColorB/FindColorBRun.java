package org.OVQ.node.image.FindColorB;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;
import PEU.movieProcessorYLJ.LYGFileIO;
public class FindColorBRun extends OSU_AVQ_ASQ_OPE_OPC_ECI{
	private static final long serialVersionUID= 1L;
	public int value= 0;
	public String filepath;
	public FindColorBRun() throws IOException{	
		super();
 	}
	public void run(final FindColorBView SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ) throws IOException{
		System.out.println("runed"+ value); 
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.path= new String(filepath); 
  		BufferedImage image= ImageIO.read(new File(filepath));
  		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout= new LYGFileIO();
	    SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout.image= image;
	}
}
