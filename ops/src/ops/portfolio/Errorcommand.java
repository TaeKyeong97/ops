package ops.portfolio;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Errorcommand {
	public static void Error(HttpServletResponse response,String message) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"');");
		out.println("history.back();");
		out.println("</script>");
	}
	public static void Error(HttpServletResponse response,String message,String direct) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"');");
		out.println("location.href='"+direct+"'");
		out.println("</script>");
	}
}
