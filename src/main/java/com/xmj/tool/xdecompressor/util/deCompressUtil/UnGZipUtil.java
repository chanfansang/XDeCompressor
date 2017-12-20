package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnGZipUtil extends DeCompressExt {

	public static void main(String[] args) throws IOException {
		UnGZipUtil u = new UnGZipUtil(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/FrmHttpsClient.java.gz");
		u.deCompress(f,"C:/Users/x1280/Desktop/");//验证通过
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		FileInputStream fis = new FileInputStream(file);
		GZIPInputStream gzis = new GZIPInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(gzis);

		File tf = new File(destpath+"/"+file.getName().replace(".gzip", ""));
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
