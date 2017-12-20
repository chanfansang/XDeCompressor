package com.xmj.tool.xdecompressor;

import java.util.ArrayList;
import java.util.List;


import com.xmj.tool.xdecompressor.action.Action;
import com.xmj.tool.xdecompressor.util.ConfigUtil;

public class XDeCompressor {
	
	public static void main(String[] args) {
		ConfigUtil cfg = new ConfigUtil("cfg/cfg.properties");
		List<String> inputPathList = new ArrayList<String>();// ��Դ�ļ�·��
		String inputPathListStr = cfg.get("inputPathList", "");
		for(String str : inputPathListStr.split(";")){
			inputPathList.add(str);// ��Դ�ļ�·��
		}
		
		String deCompressType = cfg.get("deCompressType", "zip");// ��ѹ����
		boolean isDeCompressTheDir = cfg.get("isDeCompressTheDir", false);// ��ѹ����ǰ�ļ���
		boolean isDeCompressNewDir = cfg.get("isDeCompressNewDir", true);// ��ѹ��ͬ���ļ���
		boolean isDeleteCompressFile = cfg.get("isDeleteCompressFile", false);// ɾ��ѹ���ļ�
		boolean isRecursionDeCompress = cfg.get("isRecursionDeCompress", false);// �ݹ��ѹ
		
		Action t = new Action(inputPathList,deCompressType,isDeCompressTheDir,isDeCompressNewDir,isDeleteCompressFile,isRecursionDeCompress);
		t.action();
	}

	
	
}
