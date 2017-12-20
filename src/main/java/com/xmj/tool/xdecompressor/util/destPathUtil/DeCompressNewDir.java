package com.xmj.tool.xdecompressor.util.destPathUtil;

import java.io.File;
import java.io.IOException;

import com.xmj.tool.xdecompressor.util.ext.DestPathExt;

public class DeCompressNewDir extends DestPathExt {

	@Override
	public String deCompressDir(File srcFile, String deCompressType) throws IOException {
		// TODO Auto-generated method stub
		String destpath = null;
		String dirPath = srcFile.getAbsolutePath();
		if(srcFile.getName().contains("."+deCompressType)){
			destpath = dirPath.substring(0, dirPath.lastIndexOf("."+deCompressType));
		}
		
		return destpath;
	}

}
