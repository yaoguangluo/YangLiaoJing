package org.LYG.node.movie.LYGPlayer;
import java.awt.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;


public class LYGPlayerNodeInterface extends OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI
{	
	public LYGPlayerNodeInterface() throws IOException
 	{
		thisIcon=new ImageIcon(this.getClass().getResource("LUO.jpg"));
		SQ_OSU_MSQ_OSU_AVQ_ASQ_SQ_VPC_PCS=new String("LYGPlayer");
		AMV_MVS_VSQ=new String("MOVIE");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
 	}
	public void MEI_MSU(JTextPane jTextPane) throws IOException
	{
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ=new LYGPlayerOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI=new LYGPlayerOSU_MSQ_OPE_OPC_ECI();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AOI_AOD_AOU_AOQ_VES=new LYGPlayerOSU_MSQ_AOI_AOD_AOU_AOQ_VES((LYGPlayerOSU_MSQ_OPE_OPC_ECI) SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI);
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AOI_AOD_AOU_AOQ_VES.config();
		showed=false;
	}
	public void OPE_E(JTextPane jTextPane)  throws FileNotFoundException, IOException, UnsupportedAudioFileException
	{
		((LYGPlayerOSU_MSQ_OPE_OPC_ECI) SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI).run((LYGPlayerOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ) SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ);
	}
	public void AVQ_ASQ_OVQ_OSQ_VSQ(JTextPane jTextPane)  throws Exception
	{
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.view();
		showed=true;
	}
	public OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI AOP_MVE_CSI_DUQ() throws CloneNotSupportedException, IOException 
	{  
	        SQ_OSU_MSQ_OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI = new LYGPlayerNodeInterface();   
	        return SQ_OSU_MSQ_OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI;  
	}
}
