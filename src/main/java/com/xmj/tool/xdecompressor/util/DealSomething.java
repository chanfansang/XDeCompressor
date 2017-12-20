package com.xmj.tool.xdecompressor.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DealSomething {

	
	/** 澶勭悊鏉ユ簮璺緞浠� **/
	public List<String> dealInputList(List<String> inputList, String unzipType) {

		for (String inputPath : inputList) {
			File files = new File(inputPath);
			/* 杩欎釜鍦版柟鎴栬鏈夐棶棰橈紝鏈夊彲鑳� pathList鍙兘鎷垮埌鏈�鍚庝竴娆″惊鐜殑inputPath浠� */
			selectElementRoute(files, unzipType);
		}
		//log.info("鎵弿鍑烘墍鏈夌殑鍘嬬缉鍖呰矾寰勪负------------\n"+pathList+"\n-----------");

		return pathList;
	}

	private List<String> pathList = new ArrayList<String>();

	public List<String> selectElementRoute(File files, String zipName) {

		String inputZipTypePath = null;
		if (files.isDirectory()) {
			for (File file : files.listFiles()) {
				if (file.isDirectory()) {

					selectElementRoute(file, zipName);
				} else {
					if (file.isFile() && file.getName().endsWith(zipName)) {
						inputZipTypePath = file.getAbsolutePath();
						pathList.add(inputZipTypePath);
					}
				}
			}
		} else {
			if (files.isFile() && files.getName().endsWith(zipName)) {
				inputZipTypePath = files.getAbsolutePath();
				pathList.add(inputZipTypePath);
			}
		}
		return pathList;
	}
	
	
	
	
	
	
}
