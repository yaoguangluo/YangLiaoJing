package OSI.OSU.SI.OVI.OSQ.AVQ.SI.SD.SU.SQ.ASU.OSU.PSU.MSU.AVQ.ASQ.dNA3DShow;
import java.awt.HeadlessException;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.ASQ.PSU.OCI.tinos.engine.analysis.Analyzer;

import OSI.OSU.OEQ.MCQ.GUI.OSGI.OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ;
import OSI.OSU.SI.SD.SU.SQ.ASU.OSU.PSU.MSU.AVQ.ASQ.tin.life.Application;
import biProcessor.coDNAAuthorForWord;
public class dNA3DShowOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ extends OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ{
	private static final long serialVersionUID = 1L;
	public JButton button;
	public String path;
	public ME.sample.App u;
	public Analyzer analyzer;
	public Map<String, String> pos;
	public String DNNtext;
	public dNA3DShowOSU_MSQ_AVQ_ASQ_OVQ_OSQ_VSQ(){
		super();
	}
	public void view() throws Exception{
		Application application= new Application();
		application.init();
		try {
			coDNAAuthorForWord app = null;
			try {
				app= new coDNAAuthorForWord(u, analyzer, pos);
				app.setSize(850, 400);
				app.setVisible(true);
				JFrame f= new JFrame();
				f.add(app);
				f.setTitle("DNA三维观测");
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				f.setSize(650,480);
				f.setVisible(true);
				//app.bootZynkFlowerForest("DNA三维观测", DNNtext, true);
				app.bootDNAFlowerForest("DNA三维观测", application, true);
				//application
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			close = false;
			
		}catch(Exception e) {
		}
		
	}
	@Override
	public OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ clone() {
		objectView = (OSU_AVQ_ASQ_AVQ_ASQ_OVQ_OSQ_VSQ)super.clone();  
		return objectView;  
	}  
}
