package OSI.OSU.SI.SD.SU.SQ.ASU.OSU.PSU.MSU.AVQ.ASQ.tin.dna.processor;

public class RST{
	public DNA getFatherDeque() {
		return fatherDeque;
	}
	
	public void setFatherDeque(DNA fatherDeque) {
		this.fatherDeque= fatherDeque;
	}
	
	public DNA getMotherDeque() {
		return motherDeque;
	}
	
	public void setMotherDeque(DNA motherDeque) {
		this.motherDeque= motherDeque;
	}
	
	private DNA fatherDeque;
	private DNA motherDeque;
}