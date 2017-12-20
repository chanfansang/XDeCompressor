package com.xmj.tool.xdecompressor.util.destPathUtil;

import java.io.File;
import java.io.IOException;

import com.xmj.tool.xdecompressor.util.ext.DestPathExt;

public class DeCompressTheDir extends DestPathExt {

	@Override
	public String deCompressDir(File srcFile, String deCompressType) throws IOException {
		// TODO Auto-generated method stub
		String destpath = srcFile.getAbsolutePath().substring(0,srcFile.getAbsolutePath().length()-srcFile.getName().length());
		
		return destpath;
	}

	
	public static void main(String[] args) {
		String a = "E:/work/boco/Element_Package_Tool/test/Zip/element/Delete.zip";
		File f = new File(a);
		String b = f.getAbsolutePath().substring(f.getAbsolutePath().length()-f.getName().length());
		System.out.println(b);
	}
	

}
