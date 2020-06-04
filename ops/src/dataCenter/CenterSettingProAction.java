package dataCenter;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import dataCenter.beans.DataCenterBeans;
//관심 분야 데이터 저장
public class CenterSettingProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("../PORTFOLIO/portfolioWriter",true);
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("userID");
		String field = request.getParameter("category");	//분야
		String accent = "N";
		if(field!=null) {
			accent="Y";
		}
		DataCenterBeans dcb=new DataCenterBeans();
		CenterSettingProService csps=new CenterSettingProService();
		dcb.setId(id);
		dcb.setInterest(field);
		dcb.setAgree(accent);
		dcb.setDate(new Timestamp(System.currentTimeMillis()));
		csps.centerSettingPro(dcb);
		
		
		
		return forward;
	}
}
