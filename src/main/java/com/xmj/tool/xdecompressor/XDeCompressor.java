package com.xmj.tool.xdecompressor;

import java.util.ArrayList;
import java.util.List;


import com.xmj.tool.xdecompressor.action.Action;
import com.xmj.tool.xdecompressor.util.ConfigUtil;

public class XDeCompressor {
	
	public static void main(String[] args) {
		ConfigUtil cfg = new ConfigUtil("cfg/cfg.properties");
		List<String> inputPathList = new ArrayList<String>();// 来源文件路径
		String inputPathListStr = cfg.get("inputPathList", "");
		for(String str : inputPathListStr.split(";")){
			inputPathList.add(str);// 来源文件路径
		}
		
		String deCompressType = cfg.get("deCompressType", "zip");// 解压类型
		boolean isDeCompressTheDir = cfg.get("isDeCompressTheDir", false);// 解压到当前文件夹
		boolean isDeCompressNewDir = cfg.get("isDeCompressNewDir", true);// 解压到同名文件夹
		boolean isDeleteCompressFile = cfg.get("isDeleteCompressFile", false);// 删除压缩文件
		boolean isRecursionDeCompress = cfg.get("isRecursionDeCompress", false);// 递归解压
		
		Action t = new Action(inputPathList,deCompressType,isDeCompressTheDir,isDeCompressNewDir,isDeleteCompressFile,isRecursionDeCompress);
		t.action();
	}

	
	
}
