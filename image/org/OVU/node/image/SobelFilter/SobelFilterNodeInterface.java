package org.OVU.node.image.SobelFilter;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;
public class SobelFilterNodeInterface extends OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI{	
	public SobelFilterNodeInterface() throws IOException{
		thisIcon=new ImageIcon(this.getClass().getResource("sobel.jpg"));
		SQ_OSU_MSQ_OSU_AVQ_ASQ_SQ_VPC_PCS=new String("SobelFilter");
		AMV_MVS_VSQ=new String("IMAGE");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	public void MEI_MSU(JTextPane jTextPane) throws IOException{
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ=new SobelFilterOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI=new SobelFilterOSU_MSQ_OPE_OPC_ECI();
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AOI_AOD_AOU_AOQ_VES=new SobelFilterOSU_MSQ_AOI_AOD_AOU_AOQ_VES((SobelFilterOSU_MSQ_OPE_OPC_ECI) SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI);
		SQ_OSU_MSQ_OSU_AVQ_ASQ_AOI_AOD_AOU_AOQ_VES.config();
		showed=false;
	}
	public void OPE_E(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((SobelFilterOSU_MSQ_OPE_OPC_ECI) SQ_OSU_MSQ_OSU_AVQ_ASQ_OPE_OPC_ECI).run((SobelFilterOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ) SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ);
	}
	public void AVQ_ASQ_OVQ_OSQ_VSQ(JTextPane jTextPane)  throws Exception{
		((SobelFilterOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ) SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ).view();
		showed=true;
	}
	public OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI AOP_MVE_CSI_DUQ() throws CloneNotSupportedException, IOException {  
		SQ_OSU_MSQ_OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI = new SobelFilterNodeInterface();   
		return SQ_OSU_MSQ_OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI;  
	}
}
