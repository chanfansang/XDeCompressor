package com.xmj.tool.xdecompressor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 琛ュ厖锟�?浜汼tring鐨勫鐞嗘柟锟�?
 * 
 * @author Killler
 *
 */
public class StringUtil {

	/**
	 * 鏍规嵁姝ｅ垯锛岃幏鍙栭渶瑕佺殑String锛堟鍒欎腑鎷彿鍖呰９鑼冨洿鍐咃紝鏄渶瑕佸彇鍑虹殑閮ㄥ垎锟�?
	 * <p>
	 * 渚嬪瓙:
	 * <li>String s = "S139D1-CDR-20140928210000_428023.139_1.txt";
	 * <li>String expr = "[\\w\\d]*-[\\w]*-([0-9]{4}[0-9]{2}[0-9]{2})*.*txt";
	 * <li>System.out.println(getSuiltString(expr, s, 1));
	 * </p>
	 * 
	 * @param expr
	 *            姝ｅ垯琛ㄨ揪锟�?
	 * @param str
	 *            锟�?瑕佽幏鍙栫殑String
	 * @param index
	 *            鍙栫鍑犱釜閮ㄥ垎锛屼粠1锟�?锟�?
	 * @return 鍙栧嚭缁撴灉锟�?
	 */
	public static String getSuiltString(String expr, String str, int index) {
		System.out.println(expr+"========="+str);
		Pattern pattern = Pattern.compile(expr, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			System.out.println("getSuiltString----if");
			return matcher.group(index);
		}
		System.out.println("getSuiltString----else");
		return null;
	}

	/**
	 * 鏍规嵁$[]鎻愬彇涓瓧绗︿覆涓墍鏈夌殑鍙橀噺(鎻愬嚭瀛楃涓蹭腑鍖呭惈$[])
	 * 
	 * @param str
	 *            鍖呭惈鍙橀噺鐨勫瓧绗︿覆
	 * @return 鍙橀噺鐨勯泦锟�?
	 */
	public static List<String> getParamByDollarSquareBrackets(String str) {
		Pattern p = Pattern.compile("(\\$\\[[^\\]]*\\])");
		Matcher m = p.matcher(str);
		List<String> result = new ArrayList<String>();
		while (m.find()) {
			result.add(m.group());
		}
		return result;
	}

	/**
	 * 鍒ゆ柇鏄惁鍖归厤锛屾槸锟�?瑕佸彇鍑虹殑瀛楃锟�?
	 * 
	 * @param expr
	 *            姝ｅ垯琛ㄨ揪锟�?
	 * @param str
	 *            锟�?瑕佺殑瀛楃锟�?
	 * @return 鏄惁鍖归厤鐨勭粨锟�?
	 */
	public static Boolean isMach(String expr, String str) {
		Pattern pattern = Pattern.compile(expr, Pattern.CASE_INSENSITIVE);
		//Pattern pattern = Pattern.compile(expr);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static void main(String[] args) {
		String s = "G:\\test\\test\\csv\\(.*).zip";
		String ss = "G:\\test\\test\\csv\\csv12.zip";
		
		System.out.println(isMach(s,ss));
		
		
//		String destFilePath = "opt/esb/xet/*";
//		String filePath = destFilePath.substring(0,destFilePath.lastIndexOf("/"));
//		String fileName = destFilePath.substring(destFilePath.lastIndexOf("/")+1,
//				destFilePath.length());
//		System.out.println(filePath);
//		System.out.println(fileName);
//		System.out.println(fileName.equals("*"));;
//		System.out.println(filePath+"/"+ fileName);
		
//		String s = "as/ew/r$[1]ses/dfe$[3]sd/e$[2,dateformat,yyyy,YYYY]sera$[1]afewr$[3]";
//		s = s.replaceAll("\\$\\[" + "2,dateformat,yyyy,YYYY" + "\\]", "----");
//		s = s.replaceAll("\\$\\[" + "1" + "\\]", "***");
//		System.out.println(s.substring(s.lastIndexOf("/",s.indexOf("$")),s.length()));
		
//		Map<String, String> valueMap = new HashMap<String, String>();
//		// 鐢ㄤ簬瀛樺偍鎻愬彇鍑虹殑鍙橀噺鍜屽搴旂殑锟�?
//		List<String> needParams = StringUtil
//				.getParamByDollarSquareBrackets("asewr$[1]sesdfe$[3]sde$[2,dateformat,yyyy,YYYY]sera$[1]afewr$[3]");
//		for (String needParam : needParams) {
//			valueMap.put(needParam.replaceAll("\\$\\[", "").replaceAll("\\]", ""), null);
//		}
//		for(String s :valueMap.keySet()){
//			valueMap.put(s, "awe");
//			System.out.println(s);
//		}
		
//		String s = "S139D1-CDR-20140928210000_428023.139_1.txt";
//		String expr = "[\\w\\d]*-[\\w]*-([0-9]{4}[0-9]{2}[0-9]{2})*.*txt";
//		System.out.println(getSuiltString(expr, s,1));
	}

}
