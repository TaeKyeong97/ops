package ops.announcement.Beans;

import java.sql.Timestamp;

public class Announcement {
	private int a_no;
	private String a_id;
	private String a_title;
	private String a_content;
	private Timestamp a_date;
	private String a_img;
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public Timestamp getA_date() {
		return a_date;
	}
	public void setA_date(Timestamp a_date) {
		this.a_date = a_date;
	}
	public String getA_img() {
		return a_img;
	}
	public void setA_img(String a_img) {
		this.a_img = a_img;
	}
}
