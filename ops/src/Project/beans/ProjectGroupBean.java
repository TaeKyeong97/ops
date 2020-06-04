package Project.beans;

public class ProjectGroupBean {
	private int PjG_no;
	private String pjg_admin;
	private int pjp_noFk;
	private int peSize;
	private String pjg_title;
	private String myfrofile;
	private String joinDate;
	
	public int getPjG_no() {
		return PjG_no;
	}

	public void setPjG_no(int pjG_no) {
		PjG_no = pjG_no;
	}

	public int getPeSize() {
		return peSize;
	}

	public void setPeSize(int peSize) {
		this.peSize = peSize;
	}

	public String getPjg_admin() {
		return pjg_admin;
	}

	public void setPjg_admin(String pjg_admin) {
		this.pjg_admin = pjg_admin;
	}

	public int getPjp_noFk() {
		return pjp_noFk;
	}

	public void setPjp_noFk(int pjp_noFk) {
		this.pjp_noFk = pjp_noFk;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getPjg_title() {
		return pjg_title;
	}

	public void setPjg_title(String pjg_title) {
		this.pjg_title = pjg_title;
	}

	public String getMyfrofile() {
		return myfrofile;
	}

	public void setMyfrofile(String myfrofile) {
		this.myfrofile = myfrofile;
	}
	
	
}
