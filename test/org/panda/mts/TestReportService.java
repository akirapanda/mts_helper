package org.panda.mts;

import org.junit.Test;

public class TestReportService {

	@Test
	public void testUnzipReportFiles() {
		ReportService rs = new ReportService();
		rs.unzipReportFiles();
	}
}
