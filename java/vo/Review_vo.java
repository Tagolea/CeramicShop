package vo;

public class Review_vo {
	private int rnum;
	private int rpnum;
	private String ruid;
	private String rtext;
	private String rdate;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getRpnum() {
		return rpnum;
	}
	public void setRpnum(int rpnum) {
		this.rpnum = rpnum;
	}
	public String getRuid() {
		return ruid;
	}
	public void setRuid(String ruid) {
		this.ruid = ruid;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "Review_vo [rnum=" + rnum + ", rpnum=" + rpnum + ", ruid=" + ruid + ", rtext=" + rtext + ", rdate="
				+ rdate + "]";
	}
}
