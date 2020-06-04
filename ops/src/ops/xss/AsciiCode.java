package ops.xss;

import java.util.Vector;

public class AsciiCode {
	public static Vector<String> ASCIICODE=new Vector<String>();
	public static String[] ac = new String[55204];
	AsciiCode(){
		
	}
	public static void aZ(){
		int k=0;		
		for(k=0;k<=64;k++){
			//A
			ASCIICODE.addElement("&#0"+k+";");
		}
		for(k=65;k<=90;k++){
			//A
			ASCIICODE.addElement("&#0"+k+";");
		}
		for(k=91;k<=55204;k++){
			if(k<100){
				ASCIICODE.addElement("&#0"+k+";");
			}else{
			//a
			ASCIICODE.addElement("&#"+k+";");
			}
		}
		for(k=0;k<ASCIICODE.size();k++){
			//System.out.println(ASCIICODE.elementAt(k)+" "+k);
		}
		
		char c;
		String s;
		int i=0;
		//97-123 a-z
		for(k=0;k<55204;k++){
			c=(char)k;
			s=String.valueOf(c);
			ac[i]=s;			
			i++;
		}
	}
}
