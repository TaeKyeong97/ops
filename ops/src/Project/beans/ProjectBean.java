package Project.beans;

import java.sql.Timestamp;

public class ProjectBean {
	//project (프로젝트)
	private int Pj_no;
	private String Pj_admin;
	private String Pj_title;
	private String Pj_subTitle;
	private Timestamp Pj_date;
	private String Pj_serviceDate;
	private String Pj_space;
	private String Pj_dateSlice;	//날짜만 담기
	private int pj_dateRemain;	//남은 일수
	
	//pjparti (프로젝트 구성원)
	private String Pjp_no;
	private String PjP_userId;
	private String PjP_position;	//직위
	
	//PjGroup (그룹프로젝트)
	private int PjG_no;
	private String PjG_admin;
	private String PjG_title;
	private String pjg_userId;
	
	//프로젝트현황
	private String MainP_no;
	private String MainP_id;
	private String MainP_status;
	private String MainP_Approval;
	
	
	public void ProjectBean() {}
	
	
	public int getPj_dateRemain() {
		return pj_dateRemain;
	}
	public String getPjp_no() {
		return Pjp_no;
	}
	public String getMainP_Approval() {
		return MainP_Approval;
	}
	public void setMainP_Approval(String mainP_Approval) {
		MainP_Approval = mainP_Approval;
	}
	public void setPjp_no(String pjp_no) {
		Pjp_no = pjp_no;
	}
	public String getPjg_userId() {
		return pjg_userId;
	}
	public void setPjg_userId(String pjg_userId) {
		this.pjg_userId = pjg_userId;
	}
	public void setPj_dateRemain(int pj_dateRemain) {
		this.pj_dateRemain = pj_dateRemain;
	}
	public int getPjG_no() {
		return PjG_no;
	}
	public void setPjG_no(int pjG_no) {
		PjG_no = pjG_no;
	}
	public String getPjG_admin() {
		return PjG_admin;
	}
	public void setPjG_admin(String pjG_admin) {
		PjG_admin = pjG_admin;
	}
	public String getPj_dateSlice() {
		return Pj_dateSlice;
	}
	public void setPj_dateSlice(String pj_dateSlice) {
		Pj_dateSlice = pj_dateSlice;
	}
	public String getMainP_no() {
		return MainP_no;
	}
	public void setMainP_no(String mainP_no) {
		MainP_no = mainP_no;
	}
	public String getMainP_id() {
		return MainP_id;
	}
	public void setMainP_id(String mainP_id) {
		MainP_id = mainP_id;
	}
	public String getMainP_status() {
		return MainP_status;
	}
	public void setMainP_status(String mainP_status) {
		MainP_status = mainP_status;
	}
	public String getPjG_title() {
		return PjG_title;
	}
	public void setPjG_title(String pjG_title) {
		PjG_title = pjG_title;
	}	
	public int getPj_no() {
		return Pj_no;
	}
	public void setPj_no(int pj_no) {
		Pj_no = pj_no;
	}
	public String getPj_admin() {
		return Pj_admin;
	}
	public void setPj_admin(String pj_admin) {
		Pj_admin = pj_admin;
	}
	public String getPj_title() {
		return Pj_title;
	}
	public void setPj_title(String pj_title) {
		Pj_title = pj_title;
	}
	public String getPj_subTitle() {
		return Pj_subTitle;
	}
	public void setPj_subTitle(String pj_subTitle) {
		Pj_subTitle = pj_subTitle;
	}
	public Timestamp getPj_date() {
		return Pj_date;
	}
	public void setPj_date(Timestamp pj_date) {
		Pj_date = pj_date;
	}
	public String getPj_serviceDate() {
		return Pj_serviceDate;
	}
	public void setPj_serviceDate(String pj_serviceDate) {
		Pj_serviceDate = pj_serviceDate;
	}
	public String getPj_space() {
		return Pj_space;
	}
	public void setPj_space(String pj_space) {
		Pj_space = pj_space;
	}
	public String getPjP_userId() {
		return PjP_userId;
	}
	public void setPjP_userId(String pjP_userId) {
		PjP_userId = pjP_userId;
	}
	public String getPjP_position() {
		return PjP_position;
	}
	public void setPjP_position(String pjP_position) {
		PjP_position = pjP_position;
	}
	
	
	
	
	
}
