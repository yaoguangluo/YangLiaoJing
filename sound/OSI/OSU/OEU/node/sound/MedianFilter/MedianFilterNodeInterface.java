package OSI.OSU.OEU.node.sound.MedianFilter;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;
public class MedianFilterNodeInterface extends OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI
{	
	public MedianFilterNodeInterface() throws IOException
 	{
		thisIcon=new ImageIcon(this.getClass().getResource("med.jpg"));
		SQ_OSU_MSQ_OSU_AVQ_ASQ_SQ_VPC_PCS=new String("MedianFilter");
		AMV_MVS_VSQ=new String("SOUND");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
 	}
	public void MEI_MSU(JTextPane jTextPane) throws IOException
	{
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ=new MedianFilterOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI=new MedianFilterOSU_MSQ_OPE_OPC_ECI();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AOI_AOD_AOU_AOQ_VES=new MedianFilterOSU_MSQ_AOI_AOD_AOU_AOQ_VES((MedianFilterOSU_MSQ_OPE_OPC_ECI) SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI);
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AOI_AOD_AOU_AOQ_VES.config();
		showed=false;
	}
	public void OPE_E(JTextPane jTextPane)  throws FileNotFoundException, IOException, UnsupportedAudioFileException
	{
		((MedianFilterOSU_MSQ_OPE_OPC_ECI) SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI).run((MedianFilterOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ) SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ);
	}
	public void AVQ_ASQ_OVQ_OSQ_VSQ(JTextPane jTextPane)  throws Exception
	{
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.view();
		showed=true;
	}
	public OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI AOP_MVE_CSI_DUQ() throws CloneNotSupportedException, IOException 
	{  
	        SQ_OSU_MSQ_OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI = new MedianFilterNodeInterface();   
	        return SQ_OSU_MSQ_OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI;  
	}
}
