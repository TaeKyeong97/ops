package dataCenter.beans;

import java.sql.Timestamp;

public class collectionBeans {
	private int col_no;
	private String col_boardForm;
	private String col_click;
	private Timestamp col_date;
	private String userID;
	private String in_interest;
	private String month_date;
	
	public int getCol_no() {
		return col_no;
	}
	public void setCol_no(int col_no) {
		this.col_no = col_no;
	}
	public String getCol_boardForm() {
		return col_boardForm;
	}
	public void setCol_boardForm(String col_boardForm) {
		this.col_boardForm = col_boardForm;
	}
	public String getCol_click() {
		return col_click;
	}
	public void setCol_click(String col_click) {
		this.col_click = col_click;
	}
	public Timestamp getCol_date() {
		return col_date;
	}
	public void setCol_date(Timestamp col_date) {
		this.col_date = col_date;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getIn_interest() {
		return in_interest;
	}
	public void setIn_interest(String in_interest) {
		this.in_interest = in_interest;
	}
	public String getMonth_date() {
		return month_date;
	}
	public void setMonth_date(String month_date) {
		this.month_date = month_date;
	}
	
	
}
