package Project.beans;

import java.sql.Timestamp;

public class Member {
	private String EM_id;
	private String EM_pw;
	private String EM_name;
	private String EM_bir;
	private String EM_phon;
	private String EM_email;
	private String EM_document;
	private int EM_appCode;
	private Timestamp EM_date;
	private String EM_uniqueCode;
	
	
	
	
	public Member() {}
	
	public Member(String EM_id,String EM_pw,String EM_name,String EM_bir, String EM_phon, String EM_email, String EM_document, int EM_appCode, Timestamp EM_date, String EM_uniqueCode) {
		this.EM_id =EM_id;
		this.EM_pw =EM_pw;
		this.EM_name=EM_name;
		this.EM_bir =EM_bir;
		this.EM_phon =EM_phon;
		this.EM_email =EM_email;
		this.EM_document =EM_document;
		this.EM_appCode =EM_appCode;
		this.EM_date =EM_date;
		this.EM_uniqueCode =EM_uniqueCode;
	}

	public String getEM_id() {
		return EM_id;
	}

	public void setEM_id(String eM_id) {
		EM_id = eM_id;
	}

	public String getEM_pw() {
		return EM_pw;
	}

	public void setEM_pw(String eM_pw) {
		EM_pw = eM_pw;
	}

	public String getEM_name() {
		return EM_name;
	}

	public void setEM_name(String eM_name) {
		EM_name = eM_name;
	}

	public String getEM_bir() {
		return EM_bir;
	}

	public void setEM_bir(String eM_bir) {
		EM_bir = eM_bir;
	}

	public String getEM_phon() {
		return EM_phon;
	}

	public void setEM_phon(String eM_phon) {
		EM_phon = eM_phon;
	}

	public String getEM_email() {
		return EM_email;
	}

	public void setEM_email(String eM_email) {
		EM_email = eM_email;
	}

	public String getEM_document() {
		return EM_document;
	}

	public void setEM_document(String eM_document) {
		EM_document = eM_document;
	}

	public int getEM_appCode() {
		return EM_appCode;
	}

	public void setEM_appCode(int eM_appCode) {
		EM_appCode = eM_appCode;
	}

	public Timestamp getEM_date() {
		return EM_date;
	}

	public void setEM_date(Timestamp eM_date) {
		EM_date = eM_date;
	}

	public String getEM_uniqueCode() {
		return EM_uniqueCode;
	}

	public void setEM_uniqueCode(String eM_uniqueCode) {
		EM_uniqueCode = eM_uniqueCode;
	}
	
	
	
	
}
