package com.xmj.tool.xdecompressor.util.deCompressUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import com.xmj.tool.xdecompressor.util.ext.DeCompressExt;

public class UnTarGzUtil extends DeCompressExt {

	public static void main(String[] args) throws IOException {
		UnTarGzUtil u = new UnTarGzUtil(); 
		File f = new File("C:/Users/x1280/Desktop/temp/4152_httpsclient/4152_httpsclient.tar.gz");
		u.deCompress(f,"C:/Users/x1280/Desktop/");//楠岃瘉閫氳繃
	}
	
	@Override
	public boolean deCompress(File file, String destpath) throws IOException {
		boolean isSuccess = false;
		TarInputStream tarIn = null;
		try {
			tarIn = new TarInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))),
					1024 * 2);

			createDirectory(destpath, null);// 鍒涘缓杈撳嚭鐩綍

			TarEntry entry = null;
			while ((entry = tarIn.getNextEntry()) != null) {

				if (entry.isDirectory()) {// 鏄洰褰�
					entry.getName();
					createDirectory(destpath, entry.getName());// 鍒涘缓绌虹洰褰�
				} else {// 鏄枃浠�
					File tmpFile = new File(destpath + "/" + entry.getName());
					createDirectory(tmpFile.getParent() + "/", null);// 鍒涘缓杈撳嚭鐩綍
					OutputStream out = null;
					try {
						out = new FileOutputStream(tmpFile);
						int l = 0;

						byte[] b = new byte[2048];

						while ((l = tarIn.read(b)) != -1) {
							out.write(b, 0, l);
						}

					} catch (IOException ex) {
						throw ex;
					} finally {

						if (out != null)
							out.close();
					}
				}
			}
			isSuccess = true;
		} catch (IOException ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (tarIn != null) {
					tarIn.close();
				}
			} catch (IOException ex) {

			}
		}
		return isSuccess;
	}
	
	/**
	 * 鏋勫缓鐩綍
	 * 
	 * @param outputDir
	 * @param subDir
	 */
	private void createDirectory(String outputDir, String subDir) {
		//System.out.println("outputDir---" + outputDir);
		File file = new File(outputDir);
		if (!(subDir == null || subDir.trim().equals(""))) {// 瀛愮洰褰曚笉涓虹┖
			file = new File(outputDir + "/" + subDir);
		}
		if (!file.exists()) {
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			file.mkdirs();
		}
	}

	@Override
	public void deCompressPassword(File file, String destpath, String password) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
