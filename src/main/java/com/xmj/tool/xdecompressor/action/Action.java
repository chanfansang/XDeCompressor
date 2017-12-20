package com.xmj.tool.xdecompressor.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.xmj.tool.xdecompressor.XDeCompressor;
import com.xmj.tool.xdecompressor.util.DealSomething;
import com.xmj.tool.xdecompressor.util.deCompressUtil.Un7ZipUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnBZip2Util;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnDeflateUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnGZipUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnJarUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnLZ4Util;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnSnappyUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnTarGzUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnTarUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnXzUtil;
import com.xmj.tool.xdecompressor.util.deCompressUtil.UnZipUtil;
import com.xmj.tool.xdecompressor.util.destPathUtil.DeCompressNewDir;
import com.xmj.tool.xdecompressor.util.destPathUtil.DeCompressTheDir;
import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;
import com.xmj.tool.xdecompressor.util.ext.DestPathExt;

public class Action {

	private DealSomething deal = new DealSomething();
	private List<String> destFilePathList = new ArrayList<String>();//���·��
	
	
	private List<String> inputPathList = new ArrayList<String>();// ��Դ�ļ�·��
	private String deCompressType = "";// ��ѹ����
	private boolean isDeCompressTheDir = false;// ��ѹ����ǰ�ļ���
	private boolean isDeCompressNewDir = false;// ��ѹ��ͬ���ļ���
	//private boolean isHighConf = false;// �߼�����
	private boolean isDeleteCompressFile = false;// ɾ��ѹ���ļ�
	private boolean isRecursionDeCompress = false;// �ݹ��ѹ
	//private List<ExtPath1VO> extPath1VOs;
	
	public Action(List<String> inputPathList, String deCompressType, boolean isDeCompressTheDir, 
			boolean isDeCompressNewDir, boolean isDeleteCompressFile, boolean isRecursionDeCompress){
		this.inputPathList = inputPathList;
		this.deCompressType = deCompressType;
		this.isDeCompressTheDir = isDeCompressTheDir;
		this.isDeCompressNewDir = isDeCompressNewDir;
		this.isDeleteCompressFile = isDeleteCompressFile;
		this.isRecursionDeCompress = isRecursionDeCompress;
	}

	public void action() {

		List<String> deCompressFilePath = deal.dealInputList(inputPathList, deCompressType);

		DestPathExt dest = null;
		DeCompressExt de = null;
		
		if (isDeCompressTheDir) {
			dest = new DeCompressTheDir();
		} else if (isDeCompressNewDir) {
			dest = new DeCompressNewDir();
		}

		switch (deCompressType) {
		case "7zip":
			de = new Un7ZipUtil();
			break;
		case "bzip2":
			de = new UnBZip2Util();
			break;
		case "deflate":
			de = new UnDeflateUtil();
			break;
		case "gzip":
			de = new UnGZipUtil();
			break;
		case "jar":
			de = new UnJarUtil();
			break;
		case "lz4":
			de = new UnLZ4Util();
			break;
		case "snappy":
			de = new UnSnappyUtil();
			break;
		case "tar.gz":
			de = new UnTarGzUtil();
			break;
		case "tar":
			de = new UnTarUtil();
			break;
		case "xz":
			de = new UnXzUtil();
			break;
		case "zip":
			de = new UnZipUtil();
			break;
		
		default:
			de = new UnZipUtil();
			break;
		}

		doDeCompress(de, dest, deCompressFilePath);

		List<String> result = getResultList();
		System.out.println("����ѹ���Ϊ��"+result);
		
	}
	
	private List<String> getResultList(){
		return destFilePathList;
	}

	private void doDeCompress(DeCompressExt de, DestPathExt dest, List<String> deCompressFilePath) {

		for (String filePath : deCompressFilePath) {
			File srcFile = new File(filePath);

			String destpath = null;
			boolean isSucc = false;
			try {
				destpath = dest.deCompressDir(srcFile, deCompressType);
				File f = new File(destpath);
				if(!f.exists()){
					f.mkdirs();
				}
				isSucc = de.deCompress(srcFile, destpath);

			} catch (IOException e) {
				isSucc = false;
				e.printStackTrace();
			}
			File destDir = new File(destpath);

			for (String destFilePath : destDir.list()) {
				if (!filePath.equals(destFilePath)) {
					destFilePathList.add(destFilePath);
				}
			}

			if (isDeleteCompressFile) {
				if (isSucc) {
					if (srcFile.exists() && srcFile.isFile()) {
						srcFile.delete();
					}
				}
			}
			if (isRecursionDeCompress) {
				List<String> sourceList = deal.dealInputList(destFilePathList, deCompressType);
				if(!sourceList.isEmpty()){
					doDeCompress(de, dest, sourceList);
				}
			}

		}
	}
	
}

