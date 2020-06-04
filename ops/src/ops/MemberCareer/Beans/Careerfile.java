package ops.MemberCareer.Beans;

import java.sql.Timestamp;

public class Careerfile {
	private int fileNo;
	private String fileName;
	private Timestamp fileDate;
	private String fileType;
	private int ca_no;
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Timestamp getFileDate() {
		return fileDate;
	}
	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getCa_no() {
		return ca_no;
	}
	public void setCa_no(int ca_no) {
		this.ca_no = ca_no;
	}
	
	
	
}
