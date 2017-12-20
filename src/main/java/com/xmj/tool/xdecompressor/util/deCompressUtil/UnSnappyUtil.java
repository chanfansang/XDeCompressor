package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnSnappyUtil extends DeCompressExt {

	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		FileInputStream fis = new FileInputStream(file);
		SnappyCompressorInputStream snappyis = new SnappyCompressorInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(snappyis);

		File tf = new File(destpath+"/"+file.getName().replace(".snappy", ""));
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
