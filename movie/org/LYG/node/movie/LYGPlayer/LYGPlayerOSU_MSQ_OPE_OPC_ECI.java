package org.LYG.node.movie.LYGPlayer;
import java.io.IOException;


import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;
import PEU.movieProcessorYLJ.LYGFileIO;

public class LYGPlayerOSU_MSQ_OPE_OPC_ECI extends OSU_AVQ_ASQ_OPE_OPC_ECI
{
	private static final long serialVersionUID = 1L;
	public int value = 0;
	public String filepath;
	public String writefile;
	jp jj;
	public String filepathWAV;
	public LYGPlayerOSU_MSQ_OPE_OPC_ECI()throws IOException
 	{	
 	}
	public void run(final LYGPlayerOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ) throws IOException, UnsupportedAudioFileException
	{		
		 SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout = new LYGFileIO();
		 jj = new jp(filepath);			
		 JFrame ff = new JFrame();
		 ff.add(jj);
	     ff.setSize(800, 600);
	     ff.setVisible(true);
	     System.out.println("run end");
	}
}
