package OSI.OSU.OEU.node.sound.freqCount;


import java.io.IOException;


import javax.sound.sampled.UnsupportedAudioFileException;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;



public class freqCountOSU_MSQ_OPE_OPC_ECI extends OSU_AVQ_ASQ_OPE_OPC_ECI
{
	private static final long serialVersionUID = 1L;
	public int value=0;
	public String filepath;
	public freqCountOSU_MSQ_OPE_OPC_ECI( ) throws IOException
 	{	
 	}
	public void run(final freqCountOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ) throws IOException, UnsupportedAudioFileException
	{
	  		
				 //anasys
		         int size[] = new int[9999];
		         int cacucount = 0;
                 double []reg = toplygin.adataFrame.master;
                 for(int i = 1;i<reg.length-1;i++)
                 {
                	 //find high
                	 if(reg[i]<reg[i+1]&&reg[i]<reg[i-1])
                	 {
                			 size[cacucount]++;
                			 cacucount=0;	 
                     }                	 
                     cacucount++; 
                 }
				
				 
				 SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout=toplygin;
				 SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.lygout.fsize=size;
	}
}
