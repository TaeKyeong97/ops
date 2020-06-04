package dataCenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dataCenter.beans.applySettingBeans;
import dataCenter.beans.collectionBeans;

//현재 설정값 가져오기
public class CollectionInfoListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../admin/adminster.jsp",false);

		CollectionInfoListService cils=new CollectionInfoListService();
		ArrayList<applySettingBeans> applb=cils.CollectionInfoList();
		CollectionListService cls=new CollectionListService();
		ArrayList<collectionBeans> clsb=cls.collectionList();
		ArrayList<collectionBeans> monthl=cls.monthList();
		
		//현재일 구하기
		Date now =new Date();
		SimpleDateFormat smd=new SimpleDateFormat("yyy-MM");
		String date=smd.format(now);
		
		
		
		request.setAttribute("applb", applb);
		request.setAttribute("clsb", clsb);
		request.setAttribute("monthl", monthl);
		request.setAttribute("date",date);
		return forward;
	}
}
