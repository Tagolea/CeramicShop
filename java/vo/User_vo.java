package vo;

public class User_vo{
	private String uuid;
	private String upw;
	private String uname;
	private String uph;
	private String uem;
	private String uaddr;
	private int uathu;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUph() {
		return uph;
	}
	public void setUph(String uph) {
		this.uph = uph;
	}
	public String getUem() {
		return uem;
	}
	public void setUem(String uem) {
		this.uem = uem;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public int getUathu() {
		return uathu;
	}
	public void setUathu(int uathu) {
		this.uathu = uathu;
	}
	
	@Override
	public String toString() {
		return "User_vo [uuid=" + uuid + ", upw=" + upw + ", uname=" + uname + ", uph=" + uph + ", uem=" + uem
				+ ", uaddr=" + uaddr + ", uathu=" + uathu + "]";
	}
}
