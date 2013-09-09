package org.panda.mts.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.panda.mts.Results;
import org.panda.mts.util.ZipTool;

public class FeedbackService {
	private Logger log = Logger.getLogger(FeedbackService.class.getName());
	private ZipTool zipTools = new ZipTool();

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
		zipTools.zip(file.getPath(), targetPath + "/" + file.getName() + ".zip");
		return results;
	}

}
