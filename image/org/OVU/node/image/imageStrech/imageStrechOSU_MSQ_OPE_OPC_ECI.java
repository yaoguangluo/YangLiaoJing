package org.OVU.node.image.imageStrech;
import java.io.IOException;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;
import PEU.imageProcessorYLJ.Strech;
import PEU.movieProcessorYLJ.LYGFileIO;
public class imageStrechOSU_MSQ_OPE_OPC_ECI extends OSU_AVQ_ASQ_OPE_OPC_ECI{
	private static final long serialVersionUID = 1L;
	public int value=0;
	public String filepath;
	public imageStrechOSU_MSQ_OPE_OPC_ECI( ) throws IOException{	
	}
	public void run(final imageStrechOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ) throws IOException{
		System.out.println("runed"+value);   
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout=new LYGFileIO();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout.image=new Strech().Processor(this.toplygin.image,0.1,0.9); 
	}
}
