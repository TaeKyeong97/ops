package dataCenter.beans;

import java.sql.Timestamp;

public class applySettingBeans {
	private int appc_no;
	private String appc_boardForm;
	private int appc_click;
	private Timestamp appc_date;
	private Timestamp appc_saveDate;
	private String appc_in_interest;
	private int sett_no;
	private int sett_click;
	private String sett_boardForm;
	private String sett_in_interest;
	
	public int getSett_no() {
		return sett_no;
	}
	public void setSett_no(int sett_no) {
		this.sett_no = sett_no;
	}
	public int getSett_click() {
		return sett_click;
	}
	public void setSett_click(int sett_click) {
		this.sett_click = sett_click;
	}
	public String getSett_boardForm() {
		return sett_boardForm;
	}
	public void setSett_boardForm(String sett_boardForm) {
		this.sett_boardForm = sett_boardForm;
	}
	
	public int getAppc_no() {
		return appc_no;
	}
	public void setAppc_no(int appc_no) {
		this.appc_no = appc_no;
	}
	public String getAppc_boardForm() {
		return appc_boardForm;
	}
	public void setAppc_boardForm(String appc_boardForm) {
		this.appc_boardForm = appc_boardForm;
	}
	public int getAppc_click() {
		return appc_click;
	}
	public void setAppc_click(int appc_click) {
		this.appc_click = appc_click;
	}
	public Timestamp getAppc_date() {
		return appc_date;
	}
	public void setAppc_date(Timestamp appc_date) {
		this.appc_date = appc_date;
	}
	public Timestamp getAppc_saveDate() {
		return appc_saveDate;
	}
	public void setAppc_saveDate(Timestamp appc_saveDate) {
		this.appc_saveDate = appc_saveDate;
	}
	public String getAppc_in_interest() {
		return appc_in_interest;
	}
	public void setAppc_in_interest(String appc_in_interest) {
		this.appc_in_interest = appc_in_interest;
	}
	public String getSett_in_interest() {
		return sett_in_interest;
	}
	public void setSett_in_interest(String sett_in_interest) {
		this.sett_in_interest = sett_in_interest;
	}
	
	
}
