package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnZipUtil extends DeCompressExt {

	public static void main(String[] args) throws IOException {
		UnZipUtil u = new UnZipUtil(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/4152_httpsclient.zip");
		u.deCompress(f,"C:/Users/x1280/Desktop/");//验证通过
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		
		byte[] b = new byte[1024];
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ZipInputStream zipis = new ZipInputStream(bis);
		ZipEntry zipe = null;
		//try{
			while ((zipe = zipis.getNextEntry()) != null) {
				File f = new File(destpath + "/" + zipe.getName());
				if (zipe.isDirectory()) {
					f.mkdirs();
				} else {
					
					File parent = f.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}

					FileOutputStream fos = new FileOutputStream(f);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					int l;
					while ((l = zipis.read(b)) != -1) {
						bos.write(b, 0, l);
					}
					bos.flush();
					bos.close();
				}
				zipis.closeEntry();
			}
			zipis.close();
		//}catch(Exception e){
			
		//}
		

		return true;
	}

	@Override
	public void deCompressPassword(File file, String destpath, String password) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
