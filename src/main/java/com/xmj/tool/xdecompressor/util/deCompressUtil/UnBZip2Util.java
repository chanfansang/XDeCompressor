package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnBZip2Util extends DeCompressExt {

	public static void main(String[] args) throws IOException {
		
		UnBZip2Util u = new UnBZip2Util(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/FrmHttpsClient.java.bz2");
		u.deCompress(f,"C:/Users/x1280/Desktop");//验证通过
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		FileInputStream fis = new FileInputStream(file);
		BZip2CompressorInputStream bz2is = new BZip2CompressorInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(bz2is);
		
		File tf = new File(destpath+"/"+file.getName().replace(".bz2", ""));
		FileOutputStream fos = new FileOutputStream(tf);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		write(bis, bos);
		
		return true;
	}

	@Override
	public void deCompressPassword(File file, String destpath, String password) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
