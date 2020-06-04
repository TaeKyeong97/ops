package ops.xss;

import static ops.xss.AsciiCode.ASCIICODE;
import static ops.xss.AsciiCode.ac;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

/*************************************************************************************************/
/*  크로스 사이트 스크립팅 방어																			 */
/*  제작자 : 김태경																	Kim Tae Kyeong	 */
/*  Version: v0.02																				 */
/*************************************************************************************************/
/*																								 */
/*  [목적]																						 */
/*	클라이언트에 서 작성한 HTML 문서 파일를 현재 XSS 필터링 페이지를 통해 필터한 내용을 DB에 저장 하기 위함						 */
/*																								 */
/*	[정의]																						 */
/*	필터를 거쳐 받은 내용을 ==> contents																	 */
/*	필터를 거쳐 받은 제목 ==>	Title																	 */
/*	필터를 거쳐 받은 부 제목 ==>	SubTitle																 */
/*	성능 문제로 주석 처리된 부분 선택 사용																	 */
/*																								 */
/*************************************************************************************************/
public class XssFilter implements Action {
	String []contentOn;
	String FilterMode="Developer";	//General, Developer
	boolean Xssoption=false;
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../xss/xssFilterAfter.jsp",false);
		String ASCIINumber="0";
		String Title="";
		String SubTitle="";
		String content="";
		String contents="";
		String contentIs[]=new String[]{"","0"};
		String ASCII="";
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("contents")!=null){
			content=request.getParameter("contents");
		}
		if(request.getParameter("Title")!=null){
			Title=request.getParameter("Title");
		}
		if(request.getParameter("SubTitle")!=null){
			SubTitle=request.getParameter("SubTitle");
		}
		AsciiCode.aZ();
		request.setAttribute("FilterMode", FilterMode);
		if(FilterMode==FilterModeArr[0]){
			if(content!=""){
				if(Title!=""){
					request.setAttribute("Title",Title);
				}
				if(SubTitle!=""){
					request.setAttribute("SubTitle",SubTitle);
				}
				contentIs[0]=content;
				na(contentIs);
				request.setAttribute("content",content);
				contents=contentIs[0];
				//아스키 코드값 감지 상태
				if(contentIs[1].equals("1")){
					request.setAttribute("ASCIINumber",contentIs[1]);
				}
			}
			
			if(Title!=""){
				contentIs[0]=Title;
				na(contentIs);
				Title=contentIs[0];
				//아스키 코드값 감지 상태
				if(contentIs[1].equals("1")){
					request.setAttribute("ASCIINumber",contentIs[1]);
				}
			}
			if(SubTitle!=""){
				contentIs[0]=SubTitle;
				na(contentIs);
				SubTitle=contentIs[0];
				//아스키 코드값 감지 상태
				if(contentIs[1].equals("1")){
					request.setAttribute("ASCIINumber",contentIs[1]);
				}
			}
			if(content==""&&Title==""&&SubTitle==""){
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("입력된 값이 없습니다.");
				out.println("<script>");
				out.println("alert('입력된 값이 없습니다.');");
				out.println("</script>");
			}
			request.setAttribute("contentFilter",contents);
		}else if(FilterMode==FilterModeArr[1]){
			if(content!=""){
				if(Title!=""){
					request.setAttribute("Title",Title);
				}
				if(SubTitle!=""){
					request.setAttribute("SubTitle",SubTitle);
				}
				contentIs[0]=content;
				na(contentIs);
				request.setAttribute("content",content);
				
				contents=contentIs[0];
				//아스키 코드값 감지 상태
				if(contentIs[1].equals("1")){
					request.setAttribute("ASCIINumber",contentIs[1]);
				}
			}
			
			if(Title!=""){
				contentIs[0]=Title;
				na(contentIs);
				Title=contentIs[0];
				//아스키 코드값 감지 상태
				if(contentIs[1].equals("1")){
					request.setAttribute("ASCIINumber",contentIs[1]);
				}
			}
			if(SubTitle!=""){
				contentIs[0]=SubTitle;
				na(contentIs);
				SubTitle=contentIs[0];
				//아스키 코드값 감지 상태
				if(contentIs[1].equals("1")){
					request.setAttribute("ASCIINumber",contentIs[1]);
				}
			}
			if(content==""&&Title==""&&SubTitle==""){
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("입력된 값이 없습니다.");
				out.println("<script>");
				out.println("alert('입력된 값이 없습니다.');");
				out.println("</script>");
				//response.sendRedirect(XSSURL);
			}
			request.setAttribute("contentFilter",contents);
		}
		
		
		return forward;
	}
	
	
	
	
	public String[] na(String[] contentIs){
		String ASCIINumber="0";
		String content;
		content=contentIs[0];
		
		String []contentOn= {content,"0"};
		ASCII(contentOn);
		content=contentOn[0];
		ASCIINumber=contentOn[1];
		
		if(Xssoption==true) {
		//크로스 사이트 스크립팅 방어
		/*모든 코드를 무효화 텍스트 코드만 들어가야할 페이지일 사용 (모든 코드무효화 보안:높음)*/
		String []XssName={"#","&#35;","<","&lt;",">","&gt;","\"","&quot;","\'","&#39;","=","&#61;","\\\\","&bsol;"};
		//String []XssName={"@","&commat;","[","&lsqb;","*","*",".","&period;",",","&comma;"};
		int i=0;
		for(i=0;i<XssName.length;i++){
			if(i%2==0){
				content=content.replaceAll(XssName[i],XssName[i+1]);
			}
		}
		}else{
			/*링크,스크립트 코드 무효화 (특정 코드 무효화 보안:중간)*/
			
			int i=0;
			String contents="(\\s*[a-zA-Z||=||\"||'||,||.||!||@||#||$||%||^||&||*||(||)||~||-||+||가-힣||:||>||\\\\||&bsol;||/||0-9||\\s]*)?";
			String contents2="(\\s*[a-zA-Z||=||\"||'||&bsol;||/||\\\\||0-9]*)";
			String contents3="(\\s*[a-zA-Z||0-9||=||\"||'||,||.||!||@||#||$||%||^||&||*||(||)||~||-||+||가-힣||:||\\\\||&bsol;||/]*)?";
			String contents4="([j||J])([a||A])([v||V])([a||A])([s||S])([c||C])([r||R])([i||I])([p||P])([t||T]):";
			
			String contentBuffer[];
			String Xss00="<([s||S])([c||C])([r||R])([i||I])([p||P])([t||T])(\\s)?([a-zA-z||=||\"||'||/]*)?>";
			String Xss01="</([s||S])([c||C])([r||R])([i||I])([p||P])([t||T])>";
			String Xss02="<([i||I])([m||M])([g||G])(\\s)"+contents2+"?(\\s*)?src=(['||\"||\\\\||&bsol;||/]*)?"+contents4+"([a-zA-Z||;||\"||'||.||,||=]*)(\\((['||\"||a-zA-Z||가-힣||+||;||.||,||&bsol;||/||0-9||\\s]*)?(['||\"]*)?\\))?([;||,||.||a-zA-Z||가-힣||+||=||/||:||&bsol;||/||0-9||\\s]*)?(['||\"||\\s]*)?(/)?>";
			String Xss0202="<([i||I])([m||M])([g||G])(\\s)"+contents2+"?(\\s*)?href=(['||\"||\\\\||&bsol;||/]*)?"+contents4+"([a-zA-Z||;||\"||'||.||,||=]*)(\\((['||\"||a-zA-Z||가-힣||+||;||.||,||&bsol;||/||0-9||\\s]*)?(['||\"]*)?\\))?([;||,||.||a-zA-Z||가-힣||+||=||/||:||&bsol;||/||0-9||\\s]*)?(['||\"||\\s]*)?(/)?>";
			String Xss03="<([a||A])"+contents2+"?(\\s*)?href=(['||\"||\\\\||&bsol;||/||0-9]*)?"+contents4+"([//||a-zA-Z||;||\"||'||.||,||=||0-9||#]*)(\\((['||\"||a-zA-Z||가-힣||+||;||.||,||&bsol;||/||0-9||#||\\s]*)?(['||\"]*)?\\))?([;||,||.||a-zA-Z||가-힣||+||=||/||:||&bsol;||/||0-9||\\s]*)?(['||\"||\\s]*)?(/)?>"+contents+"(</[a-zA-Z]*>)?";
			String Xss04="<([a||A])"+contents2+"?(\\s*)?src=(['||\"||\\\\||&bsol;||/]*)?"+contents4+"([//||a-zA-Z||;||\"||'||.||,||=||0-9]*)(\\((['||\"||a-zA-Z||가-힣||+||;||.||,||&bsol;||/||0-9||\\s]*)?(['||\"]*)?\\))?([;||,||.||a-zA-Z||가-힣||+||=||/||:||&bsol;||/||0-9||\\s]*)?(['||\"]*)?(/)?>"+contents+"(</[a-zA-Z]*>)?";
			String Xss05="<([i||I])([m||M])([g||G])(\\s)([a-zA-Z||=||\"||']*)?(\\s*)?src=\"javascript:";
			String Xss06="<a(\\s*[a-zA-Z||=||\"||']*)?(\\s*)?([a-zA-Z]*)?=\"javascript:";
			//String Xss07="<([s||S])([c||C])([r||R])([i||I])([p||P])([t||T])(\\s[a-zA-Z||=||\"||']*)?([a-zA-Z]*)?>(\\s[a-zA-Z||=||\"||']*)?";
			String Xss08="(\\s)onclick(\\s)?([=||\"||'||(||)]*)?"+contents3+"([=||\"||'||(||)]*)?";
			String Xss09="(\\s)?([a-zA-Z||=||\"]*)?([javascript:])?([\"||']*)?(\\s)?onclick(\\s)?([=||\"||'||(||)]*)?"+contents3+"([=||\"||'||(||)]*)?";
			//2019-03-16 추가 패치(오류)
			//String Xxx09="<([a-zA-Z]*)?(\\s[a-zA-Z]*)?([=||\"||']*)?([javascript])([:||=||\"||']*)?"+contents3+"([\"||']*)([a-zA-Z||=||\"||']*)([\"||']*)"+contents3+"(['||\"]*)>"+contents3+"</([a-zA-Z])>";
			String Xss12="<([a-zA-Z]*)(\\s)?"+contents+"(\\s)?javascript:"+contents+"(\\s)?"+contents+"(\\s)?"+contents+"(\\s)?>";
			//javascript: 모두 거르기
			//String Xss10="javascript:";
			//2019-01-29 추가 패치 onclick 제거
			String Xss11="onclick=([\"||']*)"+contents3+"([\"||']*)";
			//2019-07-25 추가 패치 oncopy,onerror
			String Xss13="<"+contents+"oncopy="+contents+">"+contents+"<(/[a-zA-Z]*)?>";
			String Xss13hypen2="<"+contents+"oncopy="+contents+">";
			String Xss14="<"+contents+"onerror="+contents+">"+contents+"<(/[a-zA-Z]*)?>";
			String Xss14hypen2="<"+contents+"onerror="+contents+">";
			
			
			String []XssName={"<!--Not Allowed Attribute Filtered (javascript:)-->",Xss02,Xss0202,Xss03,Xss04,Xss12};
			String []XssNameOption={Xss00,"<!--(Xss 비정상 적인 접근 입니다.",Xss01,"-->",Xss05,"<!--비정상적인 접근이 감지됨 현재 라인부터 입력된 모든 내용 무효화",Xss08,"",Xss11,""};
			//String []XssNameOption2={"<!--Not Allowed Attribute Filtered 스크립트 코드는 사용 할 수 없습니다.",")-->",Xss07};
			String []XssNameOptionAll={"<!--Not Allowed Attribute Filtered 스크립트 코드는 사용 할 수 없습니다.-->",Xss13,Xss14,Xss13hypen2,Xss14hypen2};
			
			content=content.replaceAll("\\\\","&bsol;");
			
			
			/*
			for(i=0;i<XssNameOption2.length;i++){
				if(i%2==0){
					if(i==0){
						content=content.replaceAll(XssNameOption2[2],XssNameOption2[0]);
					}
				}else{
					content=content.replaceAll(Xss01,XssNameOption2[1]);
				}
			}*/
			
			for(i=1;i<XssName.length;i++){
					content=content.replaceAll(XssName[i],XssName[0]);
			}
			
			for(i=0;i<XssNameOption.length;i++){
				if(i%2==0){
					content=content.replaceAll(XssNameOption[i],XssNameOption[i+1]);
				}
			}
			for(i=1;i<XssNameOptionAll.length;i++){
				content=content.replaceAll(XssNameOptionAll[i],XssNameOptionAll[0]);
			}
		}
		contentIs[0]=content;
		contentIs[1]=ASCIINumber;
		return contentIs;
	}
	String []FilterModeArr={"Developer","General"};
	
	public String[] ASCII(String []contentOn){
		String ASCIINumber="0";
	//아스키 코드값 차단
		int k=0;
		int i=0;

		/****************문자를 아스키코드화 알고르짐 ()****************/
		/*
		String test="<a href='javascript:alert()'></a>";
		String ins[]=new String[test.length()];
		for(k=0;k<test.length();k++){
			for(int gg=0;gg<ac.length;gg++){
				//문자열 검색 javascript 값을 한자리씩 검색하여 같은 값이 있을 경우 해당 인댁스 번호 저장
				if(test.substring(k,k+1).equals(ac[gg])){
					ins[k]=Integer.toString(gg);
				}
			}
		}

		String cd;
		for(k=0;k<ins.length;k++){
			cd=ins[k];
				//검색 된 값의 첫번째 방 들고 오기
				//System.out.println(ins[k]);
				i=Integer.parseInt(ins[k]);
				//System.out.print(ASCIICODE.elementAt(i));
		}
		*/
		/****************문자를 아스키 코드화 끝****************/
				
		//(아스키코드 -> 문자)
		String content=contentOn[0];
		String contents3[]=content.split("&");
		String contents4="";
		String pluse[];
		for(k=0;k<contents3.length;k++){
				for(i=20;i<=ac.length;i++){
					contents4="&"+contents3[k];
					if(ASCIICODE.elementAt(i).equals(contents4)){
						contents3[k]=contents3[k].replaceAll(contents3[k],ac[i]);
						ASCIINumber="1";//아스키 코드 발견됨
					}
				}
		}
		
		for(i=20;i<ac.length;i++){
			if(k==contents3.length){
				pluse=contents3[k-1].split(";");
				contents4="&"+pluse[0]+";";
				if(ASCIICODE.elementAt(i).equals(contents4)){
					//System.out.println(contents3[k-1]=contents3[k-1].replaceAll(pluse[0]+";",ac[i]));
				}
			}
		}
		
		contents4="";
		for(k=0;k<contents3.length;k++){
			contents4+=contents3[k];
		}
		content=contents4;
		contentOn[0]=content;
		contentOn[1]=ASCIINumber;
		return contentOn;
		
	}
	
}
