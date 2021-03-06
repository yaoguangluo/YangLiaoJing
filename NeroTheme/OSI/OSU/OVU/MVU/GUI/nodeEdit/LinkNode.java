package OSI.OSU.OVU.MVU.GUI.nodeEdit;
import OSI.OSU.OEQ.MCQ.GUI.OSGI.OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI;
public class LinkNode extends Thread{ 
	public String nodeConfiguration= "";
	public String primaryKey= "";
	public int flash= 0;
	public Boolean beconnect;
	public Boolean leftChoose;
	public Boolean rightChoose;
	public Boolean tBeconnect;
	public int tBeconnectX;
	public int tBeconnectY;
	public String tBeconnetName;
	public String tBeconnectPrimaryKey= "";
	public int tBeconnectID;
	public Boolean mBeconnect;
	public int mBeconnectX;
	public int mBeconnectY;
	public String mBeconnetName;
	public String mBeconnectPrimaryKey= "";
	public int mBeconnectID;
	public Boolean dBeconnect;
	public int dBeconnectX;
	public int dBeconnectY;
	public String dBeconnetName;
	public String dBeconnectPrimaryKey= "";
	public int dBeconnectID;
	public String name;
	public LinkNode pre;
	public LinkNode next;
	public int ID;
	public int x, y;
	public OSU_AVQ_ASQ_ASQ_OCQ_OSI_PCI_PCU_MCI_MCU_MSI thisFace; 
	public LinkNode(){}
	public void addName(String SQ_OSU_MSQ_OSU_AVQ_ASQ_SQ_VPC_PCS, int x1,int y1,int id1){
		beconnect= false;
		rightChoose= false;
		leftChoose= false;
		tBeconnect= false;
		mBeconnect= false;
		dBeconnect= false;
		x= x1;
		y= y1;
		name= new String(SQ_OSU_MSQ_OSU_AVQ_ASQ_SQ_VPC_PCS);
		ID= id1;
		tBeconnectPrimaryKey= "";
		mBeconnectPrimaryKey= "";
		dBeconnectPrimaryKey= "";
		tBeconnectID= 0;
		mBeconnectID= 0;
		dBeconnectID= 0;
		primaryKey=""+ Math.random();
	}

	public void setxy(int x1,int y1){
		x= x1;
		y= y1;
	}

	public void setchoose(Boolean choose){
		leftChoose= choose;
	}
}
