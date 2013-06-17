package org.panda.mts;

import java.util.ArrayList;
import java.util.List;

public class Results {

	private List<Result> results;

	public Results() {
		this.results = new ArrayList<Result>();
	}

	public void addResult(Result result) {
		this.results.add(result);
	}

	public boolean contains(Result result) {
		for (Result resultItem : results) {
			if (resultItem.getBranch().getNo() == result.getBranch().getNo()) {
				return true;
			}
		}
		return false;
	}

	public Result findResultByBranch(Branch branch) {
		for (Result result : this.results) {
			if (result.getBranch().getNo() == branch.getNo()) {
				return result;
			}
		}
		return null;
	}

	public void updateResult(Result result) {
		/* existing */
		if (findResultByBranch(result.getBranch()) != null) {
			/* delete & update */
		}
	}

	public void deleteResult(Result result) {
		this.results.remove(result);
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
