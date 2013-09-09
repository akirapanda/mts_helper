package org.panda.mts;

import org.panda.mts.service.FeedbackService;
import org.panda.mts.service.RequestService;

public class ReportController {
	private RequestService _requestService = new RequestService();
	private FeedbackService _feedbackService = new FeedbackService();

	/**
	 * Unzip zip file of request from branch officer
	 * 
	 * @param unzipSrcPath
	 * @param targetPath
	 */
	public void unzipRequestFiles(String unzipSrcPath, String targetPath) {
		_requestService.unzipRequestFiles(unzipSrcPath, targetPath);
	}

	/**
	 * Zip feedback file into oen by one zip file to branch officer
	 * 
	 * @param zipSrcPath
	 * @param targetPath
	 */
	public void zipResponseFiles(String zipSrcPath, String targetPath) {
		_feedbackService.zipResponseFiles(zipSrcPath, targetPath);

	}

}
