package OSI.OSU.OEU.node.sound.MaxMiniFilter;
import java.io.IOException;
import java.util.Vector;

import javax.sound.sampled.UnsupportedAudioFileException;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.*;
import soundProcessor.BytestoAIS;
import soundProcessor.MaxMiniPro;

public class MaxMiniFilterOSU_MSQ_OPE_OPC_ECI extends OSU_AVQ_ASQ_OPE_OPC_ECI
{
	private static final long serialVersionUID = 1L;
	public int value=0;
	public String filepath;
	public MaxMiniFilterOSU_MSQ_OPE_OPC_ECI( ) throws IOException
 	{	
 	}
	@SuppressWarnings({ "rawtypes", "unused" })
	public void run(final MaxMiniFilterOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ) throws IOException, UnsupportedAudioFileException
	{
	  		
				 //anasys
		 MaxMiniPro MM=new MaxMiniPro();
		 Vector lines = MM.getVectorLines(topaisin);
		 topaisin = new BytestoAIS().getAIS(MM.audioData,topaisin);
				 //play
				 //new soundPlay().Play(ais1);
		 SQ_OSU_MSQ_OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ.aisout=topaisin;
	}
}
