package OSI.OSU.SI.SD.SU.SQ.ASU.OSU.PSU.MSU.AVQ.ASQ.tin.catalytic.procedure.pde;

import java.util.List;

public class InitonLinkDNA {
	private Initon initonLink;
	private List<Initon> initonList;
	
	public void addNextIniton(Initon initon) {
		initonLink= initonLink.addNextInitons(initon);
		initonList.add(initon);
	}
	public void addPrevIniton(Initon initon) {
		initonLink= initonLink.addPrevInitons(initon);
		initonList.add(0, initon);
	}
	public Initon getInitonLink() {
		return initonLink;
	}
	
	public void setInitonLink(Initon initons) {
		initonLink= initons;
	}
}