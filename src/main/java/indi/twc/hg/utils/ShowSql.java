package indi.twc.hg.utils;

import java.util.List;
public class ShowSql {
	public static void print(String str,List plist) {      
		String showSql = str;
		for (int i = 0; i < plist.size(); i++) {
			showSql = showSql.replaceFirst("\\?", String.valueOf(plist.get(i)));
		}
		System.out.println(showSql); 
		System.out.println();
    }     
}
