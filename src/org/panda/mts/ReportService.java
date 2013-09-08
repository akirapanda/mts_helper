package org.panda.mts;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.panda.mts.util.CsvTool;
import org.panda.mts.util.ZipTool;

public class ReportService {
	private Logger log = Logger.getLogger(ReportService.class.getName());

	public void unzipRequestFiles(String unzipSrcPath, String targetPath) {

		File folder = new File(unzipSrcPath);
		int totalCount = 0;

		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				totalCount=totalCount+processZipFile(file, targetPath);
			}
		}
		log.info("total of unzip is:[ " + totalCount + " ] files");

	}

	public void zipResponseFiles(String zipSrcPath, String targetPath) {
		File folder = new File(zipSrcPath);
		int totalCount = 0;
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				proccessResponseFiles(file, targetPath);
				totalCount++;
			}
		}
		log.info("total of zip is:[ " + totalCount + " ] files");

	}

	private Results proccessResponseFiles(File file, String targetPath) {
		Results results = new Results();
		log.debug(file.getPath() + " & " + targetPath + "/" + file.getName());
		ZipTool.zip(file.getPath(), targetPath + "/" + file.getName() + ".zip");
		return results;
	}

	private int processZipFile(File file, String targetPath) {
		List<Branch> branchs = CsvTool.getBranchs();
		int count = 0;
		for (Branch branch : branchs) {
			if (file.getName().length() < 10) {
				continue;
			}

			/**
			 * 4~10byte are bank code of branch file ext name should be .zip
			 */
			if (file.getName().substring(4, 10).equals(branch.getCode())
					&& file.getName().endsWith("zip")) {

				log.debug("branch no:" + branch.getNo() + " has file:"
						+ file.getPath());

				if (branch.getZipInd() == Branch.ZIP_IND_NEED_FOLDER) {
					final String zipFileName = file.getName().substring(0,
							file.getName().length() - 3);
					/* using filename as folder name */
					File f1 = new File(targetPath + "//" + zipFileName);
					if (!f1.exists())
						f1.mkdirs();

					ZipTool.unzip(file.getPath(), targetPath + "//"
							+ zipFileName);
					log.debug("unzip file:" + file.getPath() + " to "
							+ targetPath + "//" + zipFileName);
				} else {
					ZipTool.unzip(file.getPath(), targetPath);

					log.debug("unzip file:" + file.getPath() + " to "
							+ targetPath);
				}
				count++;
			}
		}
		return count;
	}
}
