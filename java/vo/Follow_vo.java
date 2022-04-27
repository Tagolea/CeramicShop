package vo;

public class Follow_vo {
	private String pnum;
	private String follower;
	private String followed;
	
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getFollowed() {
		return followed;
	}
	public void setFollowed(String followed) {
		this.followed = followed;
	}
	@Override
	public String toString() {
		return "Follow_vo [pnum=" + pnum + ", follower=" + follower + ", followed=" + followed + "]";
	}

}
