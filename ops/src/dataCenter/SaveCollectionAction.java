package dataCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dataCenter.beans.applyCollectionBeans;

/*
 * 적용여부 저장
 */
public class SaveCollectionAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward=new ActionForward("collectionInfoList",true);
		String startDate=request.getParameter("startDate");
		String interest=request.getParameter("interest");
		String boardForm=request.getParameter("boardForm");
		String click=request.getParameter("click");
		String appc_date=startDate;
		//저장전 기존에 저장되어있는지 확인
		SelectStateCollection ssc=new SelectStateCollection();
		int selectState=ssc.selectStateCollection(startDate, interest, boardForm);
		//수집정보저장
		applyCollectionBeans acb=new applyCollectionBeans();
		acb.setAppc_boardForm(boardForm);
		acb.setAppc_click(Integer.parseInt(click));
		acb.setIn_interest(interest);		
		SaveCollectionService scs=new SaveCollectionService();
		scs.saveCollection(selectState, interest, appc_date, boardForm,click,acb);
		
		return forward;
	}
}
