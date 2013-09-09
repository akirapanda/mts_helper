package org.panda.mts;

import org.junit.Test;

public class TestReportService {

	private String UPLOAD_ZIP_PATH = "c:/testabc";
	private String UPLOAD_UNZIP_PATH = "c:/tmp";
	private String DOWNLOAD_SOURCE_PATH = "c:/tmp";
	private String DOWNLOAD_TARGET_PATH = "c:/testabc";

	@Test
	public void testUnzipReportFiles() {
		ReportController rs = new ReportController();
		rs.unzipRequestFiles(UPLOAD_ZIP_PATH, UPLOAD_UNZIP_PATH);
	}
	
	public void testZipResponseFiles() {
		ReportController rs = new ReportController();
		rs.zipResponseFiles(DOWNLOAD_SOURCE_PATH, DOWNLOAD_TARGET_PATH);
	}
}
