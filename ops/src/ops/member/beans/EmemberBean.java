package ops.member.beans;

import java.sql.Timestamp;

public class EmemberBean {
	private int en_no;
	private String en_id;
	private String en_pw;
	private String en_name;
	private String en_phone;
	private String en_Email;
	private String en_sex;
	private Timestamp en_joinData;
	private int en_confirmNum;
	private String en_img;
	private String un_uniqueCodeFk;
	private String repName;
	private String typeOfBusiness;
	private String joinNumber;
	private String repNum;
	public EmemberBean(){}
	public EmemberBean(int en_no,String en_id,String en_pw,String en_name,String en_phone,String en_Email,String en_sex,Timestamp en_joinData,int en_confirmNum,String en_img,String un_uniqueCodeFk,String repName,String typeOfBusiness,String joinNumber,String repNum) {
		this.en_no=en_no;
		this.en_id=en_id;
		this.en_pw=en_pw;
		this.en_name=en_name;
		this.en_phone=en_phone;
		this.en_Email=en_Email;		
		this.en_sex=en_sex;
		this.en_joinData=en_joinData;
		this.en_confirmNum=en_confirmNum;
		this.en_img=en_img;
		this.un_uniqueCodeFk=un_uniqueCodeFk;
		this.repName=repName;
		this.typeOfBusiness=typeOfBusiness;
		this.joinNumber=joinNumber;
		this.repNum=repNum;
	}
	
	public int getEn_no() {
		return en_no;
	}
	public void setEn_no(int en_no) {
		this.en_no = en_no;
	}
	public String getEn_id() {
		return en_id;
	}
	public void setEn_id(String en_id) {
		this.en_id = en_id;
	}
	public String getEn_pw() {
		return en_pw;
	}
	public void setEn_pw(String en_pw) {
		this.en_pw = en_pw;
	}
	public String getEn_name() {
		return en_name;
	}
	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}
	public String getEn_phone() {
		return en_phone;
	}
	public void setEn_phone(String en_phone) {
		this.en_phone = en_phone;
	}
	public String getEn_Email() {
		return en_Email;
	}
	public void setEn_Email(String en_Email) {
		this.en_Email = en_Email;
	}
	public String getEn_sex() {
		return en_sex;
	}
	public void setEn_sex(String en_sex) {
		this.en_sex = en_sex;
	}
	public Timestamp getEn_joinData() {
		return en_joinData;
	}
	public void setEn_joinData(Timestamp en_joinData) {
		this.en_joinData = en_joinData;
	}
	public int getEn_confirmNum() {
		return en_confirmNum;
	}
	public void setEn_confirmNum(int en_confirmNum) {
		this.en_confirmNum = en_confirmNum;
	}
	public String getEn_img() {
		return en_img;
	}
	public void setEn_img(String en_img) {
		this.en_img = en_img;
	}
	public String getUn_uniqueCodeFk() {
		return un_uniqueCodeFk;
	}
	public void setUn_uniqueCodeFk(String un_uniqueCodeFk) {
		this.un_uniqueCodeFk = un_uniqueCodeFk;
	}
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}
	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}
	public String getJoinNumber() {
		return joinNumber;
	}
	public void setJoinNumber(String joinNumber) {
		this.joinNumber = joinNumber;
	}
	public String getRepNum() {
		return repNum;
	}
	public void setRepNum(String repNum) {
		this.repNum = repNum;
	}
	
	
	
}
