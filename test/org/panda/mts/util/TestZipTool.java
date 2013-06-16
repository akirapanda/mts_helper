package org.panda.mts.util;

import org.junit.Test;

public class TestZipTool {
	@Test
	public void TestCompress() {
		ZipTool.zip("c:\\testabc", "C:\\tmp\\testabc.zip");
	}
	@Test
	public void testUnzip() {
		ZipTool.unzip("C:/tmp/testabc.zip", "C:/tmp/testabc");
	}
}
