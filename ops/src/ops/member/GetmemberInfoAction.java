package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.beans.MemberBean;
//공개 가능한 나의 회원 정보 가져오기
public class GetmemberInfoAction{
	public MemberBean getmemberInfo(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session=request.getSession();
			String myID=(String)session.getAttribute("userID");
			GetmemberInfoService gis=new GetmemberInfoService();
			MemberBean mb=gis.getUserInfo(myID);
			return mb;
	}
}
