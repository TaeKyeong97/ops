package Project.beans;

import java.sql.Timestamp;

public class Work {
	
	private int Wo_no;
	private String Wo_write;
	private String Wo_title;
	private String Wo_content;
	private Timestamp Wo_date;
	
	private String Wo_StratDate;
	private String Wo_EndDate;
	private int Wo_status;
	private String Wo_sortation;
	private int PjP_noFk;
	
	private int ws_no;
	private String ws_receive;
	
	public int getWs_no() {
		return ws_no;
	}
	public void setWs_no(int ws_no) {
		this.ws_no = ws_no;
	}
	
	public Work() {};
	public Work(int Wo_no,String Wo_write,String Wo_title,String Wo_content,Timestamp Wo_date, String Wo_StratDate ,String Wo_EndDate ,int Wo_status,String Wo_sortation , int PjP_noFk) {
		this.Wo_write=Wo_write;
		this.Wo_title=Wo_title;
		this.Wo_content=Wo_content;
		this.Wo_date=Wo_date;
		this.Wo_StratDate=Wo_StratDate;
		this.Wo_EndDate=Wo_EndDate;
		this.Wo_status=Wo_status;
		this.Wo_sortation=Wo_sortation;
		this.PjP_noFk=PjP_noFk;
	}
	
	public int getWo_no() {
		return Wo_no;
	}
	public void setWo_no(int wo_no) {
		Wo_no = wo_no;
	}
	public String getWo_write() {
		return Wo_write;
	}
	public void setWo_write(String wo_write) {
		Wo_write = wo_write;
	}
	public String getWo_title() {
		return Wo_title;
	}
	public void setWo_title(String wo_title) {
		Wo_title = wo_title;
	}
	public String getWo_content() {
		return Wo_content;
	}
	public void setWo_content(String wo_content) {
		Wo_content = wo_content;
	}
	public Timestamp getWo_date() {
		return Wo_date;
	}
	public void setWo_date(Timestamp wo_date) {
		Wo_date = wo_date;
	}
	public String getWo_StratDate() {
		return Wo_StratDate;
	}
	public void setWo_StratDate(String wo_StratDate) {
		Wo_StratDate = wo_StratDate;
	}
	public String getWo_EndDate() {
		return Wo_EndDate;
	}
	public void setWo_EndDate(String wo_EndDate) {
		Wo_EndDate = wo_EndDate;
	}
	public int getWo_status() {
		return Wo_status;
	}
	public void setWo_status(int wo_status) {
		Wo_status = wo_status;
	}
	public String getWo_sortation() {
		return Wo_sortation;
	}
	public void setWo_sortation(String wo_sortation) {
		Wo_sortation = wo_sortation;
	}

	public int getPjP_noFk() {
		return PjP_noFk;
	}

	public void setPjP_noFk(int pjP_noFk) {
		PjP_noFk = pjP_noFk;
	}
	public String getWs_receive() {
		return ws_receive;
	}
	public void setWs_receive(String ws_receive) {
		this.ws_receive = ws_receive;
	}
	
	
}
