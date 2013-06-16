package org.panda.mts.util;

import org.junit.Test;
import org.panda.mts.util.Config;

public class TestConfig {
	@Test
	public void testGetKey() {
		Config f = new Config("config.property");
		System.out.println(f.getValue("BRANCH_LIST"));
		System.out.println(f.getValue("BRANCH_LIST"));
	}
}
