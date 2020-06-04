package dataCenter.beans;

import java.sql.Timestamp;

//수집정보 적용 빈즈
public class applyCollectionBeans {
	private int appc_no;
	private String appc_boardForm;
	private int appc_click;
	private Timestamp appc_date;
	private Timestamp appc_saveDate;
	private String in_interest;
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
	public String getIn_interest() {
		return in_interest;
	}
	public void setIn_interest(String in_interest) {
		this.in_interest = in_interest;
	}
	
	
}
