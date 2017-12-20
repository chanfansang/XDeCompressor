package com.xmj.tool.xdecompressor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 鏃ユ湡鏍煎紡鍖栨柟锟�?
 * 
 * @author Killler
 *
 */
public class DateFormatFun {

	/**
	 * 璁叉棩鏈熷瓧绗︿覆鐢辨潵婧愭牸寮忚浆鍖栦负鐩爣鏍煎紡
	 * 
	 * @param dateStr
	 *            鏃ユ湡瀛楃锟�?
	 * @param sourceFormat
	 *            鍘熸湰鐨勬棩鏈熸牸锟�?
	 * @param destFormat
	 *            鏂扮殑鏃ユ湡鏍煎紡
	 * @return 杞寲瀹屾垚鐨勬棩锟�?
	 */
	public static String transDateStr(String dateStr, String sourceFormat,
			String destFormat) {
		SimpleDateFormat sourceSDF = new SimpleDateFormat(sourceFormat);
		SimpleDateFormat destSDF = new SimpleDateFormat(destFormat);
		try {
			Date date = sourceSDF.parse(dateStr);
			String destDateStr = destSDF.format(date);
			return destDateStr;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
