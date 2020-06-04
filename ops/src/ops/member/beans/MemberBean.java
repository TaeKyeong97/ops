package ops.member.beans;

import java.sql.Timestamp;

public class MemberBean {
	//기본
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String sex;
	private Timestamp joinData;
	private String po_address;
	private String zipNo;
	private String roadAddr;
	private String jibunAddr;
	private String realAddr;
	
	//추가 예정
	private String birthday;	//생년월일 (10)
	private String profile;	//프로필이미지
	
	//
	public MemberBean() {};
	public MemberBean(String id,String pw,String name,String phone,String email,String sex,Timestamp joinData,String zipNo,String roadAddr, String jibunAddr,String realAddr,String profile,String birthday ) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.phone=phone;
		this.email=email;
		this.sex=sex;
		this.joinData=joinData;
		this.zipNo=zipNo;
		this.roadAddr=roadAddr;
		this.jibunAddr=jibunAddr;
		this.realAddr=realAddr;
		this.profile=profile;
		this.birthday=birthday;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Timestamp getJoinData() {
		return joinData;
	}
	public void setJoinData(Timestamp joinData) {
		this.joinData = joinData;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPo_address() {
		return po_address;
	}
	public void setPo_address(String po_address) {
		this.po_address = po_address;
	}
	public String getZipNo() {
		return zipNo;
	}
	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}
	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}
	public String getJibunAddr() {
		return jibunAddr;
	}
	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}
	public String getRealAddr() {
		return realAddr;
	}
	public void setRealAddr(String realAddr) {
		this.realAddr = realAddr;
	}
	
	
}
