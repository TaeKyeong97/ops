package Project.beans;

import java.sql.Timestamp;

public class ProjectGroupProject {
	private int pjgp_no;
	private String pjgp_title;
	private String pjgp_content;
	private String startDate;
	private String endDate;
	private Timestamp pjgp_date;
	private int pjgp_division;
	private int pjg_no;
	public int getPjgp_no() {
		return pjgp_no;
	}
	public void setPjgp_no(int pjgp_no) {
		this.pjgp_no = pjgp_no;
	}
	public String getPjgp_title() {
		return pjgp_title;
	}
	public void setPjgp_title(String pjgp_title) {
		this.pjgp_title = pjgp_title;
	}
	public String getPjgp_content() {
		return pjgp_content;
	}
	public void setPjgp_content(String pjgp_content) {
		this.pjgp_content = pjgp_content;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Timestamp getPjgp_date() {
		return pjgp_date;
	}
	public void setPjgp_date(Timestamp pjgp_date) {
		this.pjgp_date = pjgp_date;
	}
	public int getPjgp_division() {
		return pjgp_division;
	}
	public void setPjgp_division(int pjgp_division) {
		this.pjgp_division = pjgp_division;
	}
	public int getPjg_no() {
		return pjg_no;
	}
	public void setPjg_no(int pjg_no) {
		this.pjg_no = pjg_no;
	}
	
	
}
