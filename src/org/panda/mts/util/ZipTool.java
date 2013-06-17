package org.panda.mts.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class ZipTool {

	private static Logger logger = Logger.getLogger(ZipTool.class);

	public static void zip(String srcPathName, String desFileName) {

		File zipFile = new File(desFileName);
		File srcdir = new File(srcPathName);
		if (!srcdir.exists())
			throw new RuntimeException(srcPathName + "不存在！");

		Project prj = new Project();
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		zip.addFileset(fileSet);

		zip.execute();

		logger.debug("zip dir:" + srcPathName + " to " + desFileName);
	}

	@SuppressWarnings("rawtypes")
	public static void unzip(String zipFileName, String outputDirectory) {
		try {
			ZipFile zipFile = new ZipFile(zipFileName);
			java.util.Enumeration e = zipFile.getEntries();

			ZipEntry zipEntry = null;
			/** 1.先建立目录结构 **/
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				if (zipEntry.isDirectory()) {
					String name = zipEntry.getName();
					name = name.substring(0, name.length() - 1);
					mkDirs(outputDirectory + File.separator + name);
					System.out.println("dir:" + outputDirectory
							+ File.separator + name);
				}
			}

			/** 2.再进行及压缩文件，避免路径不存在导致的错误 **/
			e = zipFile.getEntries();
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				if (!zipEntry.isDirectory()) {

					File f = new File(outputDirectory + File.separator
							+ zipEntry.getName());
					logger.debug("output directory:" + outputDirectory);
					logger.debug("file path is:" + zipEntry.getName());
					if (outputDirectory.endsWith(".")) {
						outputDirectory = outputDirectory.substring(0,
								outputDirectory.length() - 1);
					}

					System.out.println(outputDirectory + File.separator
							+ zipEntry.getName());

					f.createNewFile();
					InputStream in = zipFile.getInputStream(zipEntry);
					FileOutputStream out = new FileOutputStream(f);
					int c;
					byte[] by = new byte[1024];
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					out.close();
					in.close();
				}
			}
		} catch (Exception ex) {
			System.out.println("解压文件异常" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * 创建目录，包括子目录
	 */
	private static void mkDirs(String dir) throws Exception {
		if (dir == null || dir.equals(""))
			return;
		File f1 = new File(dir);
		if (!f1.exists())
			f1.mkdirs();
	}
}
