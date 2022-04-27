package vo;

public class Product_vo {
	private int pnum;
	private String puid;
	private String pname;
	private String ptext;
	private int pprice;
	private int pstock;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPuid() {
		return puid;
	}
	public void setPuid(String puid) {
		this.puid = puid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtext() {
		return ptext;
	}
	public void setPtext(String ptext) {
		this.ptext = ptext;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	
	@Override
	public String toString() {
		return "Product_vo [pnum=" + pnum + ", puid=" + puid + ", pname=" + pname + ", ptext=" + ptext + ", pprice="
				+ pprice + ", pstock=" + pstock + "]";
	}
}
