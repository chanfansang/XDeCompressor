package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnTarUtil extends DeCompressExt {

	public static void main(String[] args) throws IOException {
		UnTarUtil u = new UnTarUtil(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/4152_httpsclient.tar");
		u.deCompress(f,"C:/Users/x1280/Desktop/");//楠岃瘉閫氳繃
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		byte[] b = new byte[1024];
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		TarArchiveInputStream tarais = new TarArchiveInputStream(bis);
		TarArchiveEntry tarae = null;
		while ((tarae = tarais.getNextTarEntry()) != null) {
			File f = new File(destpath + "/" + tarae.getName());
			if (tarae.isDirectory()) {
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
				while ((l = tarais.read(b)) != -1) {
					bos.write(b, 0, l);
				}
				bos.flush();
				bos.close();
			}
		}
		tarais.close();
		
		return true;
	}

	@Override
	public void deCompressPassword(File file, String destpath, String password) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
