package org.panda.mts;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.panda.mts.util.CsvTool;

public class TestResult {

	@Test
	public void testUpdate() {
		Results results = new Results();
		List<Branch> branchs = CsvTool.getBranchs();

		for (Branch branch : branchs) {
			Result result = new Result();
			
			result.setBranch(branch);
			result.setSuccessCount(1);
			results.addResult(result);
		}
		Assert.assertEquals(branchs.size(), results.getResults().size());

		Result result = new Result();
		result.setBranch(branchs.get(2));

		results.deleteResult(result);
		print(results);


	}

	private void print(Results results) {
		int i = 0;
		for (Result res : results.getResults()) {
			System.out.println(i + ":" + res.getBranch().getNo());
			i++;
		}
	}
}
