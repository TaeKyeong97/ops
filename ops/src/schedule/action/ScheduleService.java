package schedule.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import schedule.beans.ScheduleBeans;

public class ScheduleService {
	//스케줄 조회
	public ArrayList<ScheduleBeans> schedule(int no){
		Connection conn=getConnection();
		ScheduleDAO sd=ScheduleDAO.getInstance();
		sd.setConnection(conn);
		ArrayList<ScheduleBeans> list=sd.scheduleList(no);
		
		close(conn);
		return list;
	}
}
