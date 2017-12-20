package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnJarUtil extends DeCompressExt {

	public static void main(String[] args) throws IOException {
		UnJarUtil u = new UnJarUtil(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/HttpChannelLogout.jar");
		u.deCompress(f,"C:/Users/x1280/Desktop/");//楠岃瘉閫氳繃
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		byte[] b = new byte[1024];
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		JarArchiveInputStream jaris = new JarArchiveInputStream(bis);
		JarArchiveEntry jarae = null;
		while ((jarae = jaris.getNextJarEntry()) != null) {
			File f = new File(destpath + "/" + jarae.getName());
			if (jarae.isDirectory()) {
				f.mkdirs();
			} else {
				/*
				 * 鐖剁洰褰曚笉瀛樺湪鍒欏垱寤�
				 */
				File parent = f.getParentFile();
				if (!parent.exists()) {
					parent.mkdirs();
				}

				FileOutputStream fos = new FileOutputStream(f);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				int l;
				while ((l = jaris.read(b)) != -1) {
					bos.write(b, 0, l);
				}
				bos.flush();
				bos.close();
			}
		}
		jaris.close();

		return true;
	}

	@Override
	public void deCompressPassword(File file, String destpath, String password) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
