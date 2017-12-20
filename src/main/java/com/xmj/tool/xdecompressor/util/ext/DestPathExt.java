package com.xmj.tool.xdecompressor.util.ext;

import java.io.File;
import java.io.IOException;

public abstract class DestPathExt {
	
	public abstract String deCompressDir(File srcFile, String deCompressType) throws IOException;

	/*public abstract void deCompressTheDir(File srcFile, String destpath) throws IOException;
	
	public abstract void deCompressNewDir(File srcFile, String destpath) throws IOException;
	
	public abstract void highConf(File srcFile, String destpath) throws IOException;
	*/
}
