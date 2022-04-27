package vo;

public class Comment_vo {
	private int cnum;
	private int canum;
	private String cuid;
	private String ctext;
	private String cdate;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getCanum() {
		return canum;
	}
	public void setCanum(int canum) {
		this.canum = canum;
	}
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getCtext() {
		return ctext;
	}
	public void setCtext(String ctext) {
		this.ctext = ctext;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	@Override
	public String toString() {
		return "Comment_vo [cnum=" + cnum + ", canum=" + canum + ", cuid=" + cuid + ", ctext=" + ctext + ", cdate="
				+ cdate + "]";
	}
}
