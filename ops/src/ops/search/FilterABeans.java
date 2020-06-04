package ops.search;

public class FilterABeans {
	private String local;				//지역
	private String detailLocal;			//상세지역
	private String industry;			//업종
	private String detailIndustry;		//상세 업종
	private String acbg;				//학력 (중학교,고등학교)
	private String acbgState;			//학력 상태
	private String money;				//연봉
	private String sex;					//성별	
	public FilterABeans() {}
	public FilterABeans(String local,String detailLocal,String industry,String detailIndustry,String acbg,String acbgState,String money,String sex ) {
		this.local=local;
		this.detailLocal=detailLocal;
		this.industry=industry;
		this.detailIndustry=detailIndustry;
		this.acbg=acbg;
		this.acbgState=acbgState;
		this.money=money;
		this.sex=sex;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getDetailLocal() {
		return detailLocal;
	}
	public void setDetailLocal(String detailLocal) {
		this.detailLocal = detailLocal;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDetailIndustry() {
		return detailIndustry;
	}
	public void setDetailIndustry(String detailIndustry) {
		this.detailIndustry = detailIndustry;
	}
	public String getAcbg() {
		return acbg;
	}
	public void setAcbg(String acbg) {
		this.acbg = acbg;
	}
	public String getAcbgState() {
		return acbgState;
	}
	public void setAcbgState(String acbgState) {
		this.acbgState = acbgState;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}

