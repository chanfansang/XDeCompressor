package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class Un7ZipUtil extends DeCompressExt {

	
	public static void main(String[] args) throws IOException {
		Un7ZipUtil u = new Un7ZipUtil(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/4152_httpsclient.7z");
		u.deCompress(f,"C:/Users/x1280/Desktop/");//验证通过
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {

		byte[] b = new byte[1024];
		SevenZFile szf = new SevenZFile(file);
		SevenZArchiveEntry entry;
		while ((entry = szf.getNextEntry()) != null) {
			entry.getWindowsAttributes();		
			File f = new File(destpath + "/" + entry.getName());
			if (entry.isDirectory()) {
				f.mkdirs();
			} else {
				File parent = f.getParentFile();
				if (!parent.exists()) {
					parent.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(f);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				int l;
				while ((l = szf.read(b)) != -1) {
					bos.write(b, 0, l);
				}
				bos.flush();
				bos.close();
			}
		}

		return true;
	}

	@Override
	public void deCompressPassword(File file, String destpath, String password) throws IOException {
		// TODO Auto-generated method stub

	}

}
