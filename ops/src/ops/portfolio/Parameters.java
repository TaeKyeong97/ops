package ops.portfolio;

import javax.servlet.http.HttpServletRequest;

public class Parameters {
	public static StringBuffer isParameter(HttpServletRequest request,String[] param){
		StringBuffer parameter=new StringBuffer();
		for(int paraLen=0;paraLen<param.length;paraLen++) {
			if(request.getParameter(param[paraLen])!=null) {
				if(paraLen==0) {
					parameter.append(request.getParameter(param[paraLen]));
				}else{
					parameter.append(","+request.getParameter(param[paraLen]));
				}
			}
		}
		return parameter;
	}
}
