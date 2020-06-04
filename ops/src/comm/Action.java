package comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {	//인터페이스
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}