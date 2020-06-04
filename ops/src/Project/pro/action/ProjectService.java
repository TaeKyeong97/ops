package Project.pro.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.Chatting;
import Project.beans.ProjectBean;

public class ProjectService {
	//프로젝트 정보 가져오기
	public ArrayList<ProjectBean> opProjectMain(String pj_no) {
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectBean> list=opd.opMainProject(pj_no);
		
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}
	//프로젝트 참여 인원 가져오기
	public ArrayList<ProjectBean> opMainPersonProject(String pj_no, String myid){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectBean> list=opd.opMainProjectPerson(pj_no);
		
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}
	
	//프로젝트 그룹 정보 가져오기
	public ArrayList<ProjectBean> opMainGroupPersonProject(String pj_no){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectBean> list=opd.opMainProjectGroupPerson(pj_no);
		
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}
	
	//프로젝트 그룹수
	public int opProjectGroupcount(String pj_no) {
		int state=0;
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		state=opd.projectGroupCount(pj_no);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return state;
	}
	//프로젝트 참여인원
	public int opProjectPecount(String pj_no) {
		int state=0;
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		state=opd.projectPeCount(pj_no);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return state;
	}
	
	//프로젝트 참여 권한 확인
	public ProjectBean opMainProjectRightService(String pj_no,String myid) {
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		
		ProjectBean pjb=opd.opMainProjectRight(pj_no, myid);
		
		
		
		close(conn);
		return pjb;
	}
	
	
	//승인대기중인 친구 목록
	public ArrayList<Chatting> chattingAck(String myId){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<Chatting> list= opd.chattingAck(myId);
		
		close(conn);
		return list;
	}
	//승인한 친구목록
	public ArrayList<Chatting> chatting(String myId){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<Chatting> list=opd.chatting(myId);
		
		
		close(conn);
		return list;
	}
		
}
