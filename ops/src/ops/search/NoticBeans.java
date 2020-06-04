package ops.search;

import java.sql.Timestamp;

public class NoticBeans {
	private int n_no;
	private String n_title;
	private Timestamp n_date;
	private String n_content;
	private String n_img;
	private String n_startDate;
	private String n_endDate;
	private String n_comName;
	private int en_no;
	
	public String getN_comName() {
		return n_comName;
	}
	public void setN_comName(String n_comName) {
		this.n_comName = n_comName;
	}
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public Timestamp getN_date() {
		return n_date;
	}
	public void setN_date(Timestamp n_date) {
		this.n_date = n_date;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_img() {
		return n_img;
	}
	public void setN_img(String n_img) {
		this.n_img = n_img;
	}
	public String getN_startDate() {
		return n_startDate;
	}
	public void setN_startDate(String n_startDate) {
		this.n_startDate = n_startDate;
	}
	public String getN_endDate() {
		return n_endDate;
	}
	public void setN_endDate(String n_endDate) {
		this.n_endDate = n_endDate;
	}
	public int getEn_no() {
		return en_no;
	}
	public void setEn_no(int en_no) {
		this.en_no = en_no;
	}
	
}
