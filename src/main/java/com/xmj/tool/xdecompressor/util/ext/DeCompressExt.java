package com.xmj.tool.xdecompressor.util.ext;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

public abstract class DeCompressExt {

	
	public abstract boolean deCompress(File file, String destpath) throws IOException;
	
	
	public abstract void deCompressPassword(File srcFile, String destpath, String password) throws IOException;
	
	/**
	 * 浠巄is璇诲彇鏁版嵁骞跺啓鍏os涓�
	 * @param bis
	 * @param bos
	 * @throws IOException
	 */
	public void write(BufferedInputStream bis, BufferedOutputStream bos) throws IOException {
		byte[] b = new byte[1024];
		int l;
		while((l = bis.read(b)) > 0) {
			bos.write(b, 0, l);
		}
		bos.flush();
		bos.close();
		bis.close();
	}
	
}
