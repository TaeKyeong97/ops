package ops.member;

import java.util.HashMap;

public class LicenceseSearchService {
	//사업자 등록 조회
	public HashMap<String, String> emBusinessLicence(String liceName,String liceNum){
		HashMap<String, String> lice=new HashMap<String, String>();
		MemberDAO md=MemberDAO.getInstance();
		try {
			lice=md.EmBusinessLicence(liceName, liceNum);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return lice;
	}
}
