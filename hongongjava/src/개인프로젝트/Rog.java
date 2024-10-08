package 개인프로젝트;

public class Rog extends Dao {
	
	private String mid;
	private String mpw;
	private String mname;
	private String tell;
	private String responsibility;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	
	
	@Override
	public String toString() {
		return "Rog [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", tell=" + tell + ", responsibility="
				+ responsibility + "]";
	}
	
	
	

}//end class
