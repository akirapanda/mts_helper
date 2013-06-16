package org.panda.mts.util;

import junit.framework.Assert;

import org.junit.Test;

public class TestCsvTool {
	@Test
	public void testGetBranchs() {
		Assert.assertEquals(0, CsvTool.getBranchs().get(0).getZipInd());

	}
}
