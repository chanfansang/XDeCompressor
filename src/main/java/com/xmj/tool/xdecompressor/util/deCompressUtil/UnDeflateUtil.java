package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnDeflateUtil extends DeCompressExt {

	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		FileInputStream fis = new FileInputStream(file);
		DeflateCompressorInputStream deflateis = new DeflateCompressorInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(deflateis);
		File tf = null;
		if(file.getName().contains(".deflate")){
			tf = new File(destpath+"/"+file.getName().replace(".deflate", ""));
		}else{
			tf = new File(destpath+"/"+file.getName().replace(".gz", ""));
		}
		
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
