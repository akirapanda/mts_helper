package org.panda.mts;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.panda.mts.util.Config;
import org.panda.mts.util.CsvTool;
import org.panda.mts.util.ZipTool;

public class ReportService {
	Logger log = Logger.getLogger(ReportService.class.getName());

	Config cf = new Config("config.property");
	String zipFileFolder = cf.getValue("UPLOAD_ZIP_PATH");
	String unzipFileFolder = cf.getValue("UPLOAD_UNZIP_PATH");

	public void unzipReportFiles() {

		List<Branch> branchs = CsvTool.getBranchs();

		File folder = new File(zipFileFolder);
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				processZipFile(file);
			}
		}

	}

	private void processZipFile(File file) {
		List<Branch> branchs = CsvTool.getBranchs();

		for (Branch branch : branchs) {
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
					ZipTool.unzip(file.getPath(), unzipFileFolder + "//"
							+ zipFileName);

					log.debug("unzip file:" + file.getPath() + " to "
							+ unzipFileFolder + "//" + zipFileName);
				} else {
					ZipTool.unzip(file.getPath(), unzipFileFolder);

					log.debug("unzip file:" + file.getPath() + " to "
							+ unzipFileFolder);
				}

			}
		}
	}

	public void upload() {

	}
}
