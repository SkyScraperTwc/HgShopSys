package indi.twc.hg.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static String getStringNoBlank(String str) {      
        if(str!=null && !"".equals(str)) {      
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");      
            Matcher m = p.matcher(str);      
            String strNoBlank = m.replaceAll("");      
            return strNoBlank;      
        }else {      
            return str;      
        }           
    }     
}
