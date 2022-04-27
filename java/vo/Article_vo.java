package vo;

public class Article_vo {
	private int anum;
	private String atitle;
	private String auid;
	private String auname;
	private String atext;
	private String adate;
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getAtitle() {
		return atitle;
	}
	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}
	public String getAuid() {
		return auid;
	}
	public void setAuid(String auid) {
		this.auid = auid;
	}
	public String getAuname() {
		return auname;
	}
	public void setAuname(String auname) {
		this.auname = auname;
	}
	public String getAtext() {
		return atext;
	}
	public void setAtext(String atext) {
		this.atext = atext;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "Article_vo [anum=" + anum + ", atitle=" + atitle + ", auid=" + auid + ", auname=" + auname + ", atext="
				+ atext + ", adate=" + adate + "]";
	}
}