package org.panda.mts.util;

import org.junit.Before;
import org.junit.Test;

public class TestZipTool {

	ZipTool zipTool=new ZipTool();
	@Before
	public void setup(){
		
	}
	@Test
	public void TestCompress() {
		zipTool.zip("c:\\testabc", "C:\\tmp\\testabc.zip");
	}
	@Test
	public void testUnzip() {
		zipTool.unzip("C:/tmp/testabc.zip", "C:/tmp/testabc");
	}
}
