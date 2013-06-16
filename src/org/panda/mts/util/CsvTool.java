package org.panda.mts.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.panda.mts.Branch;

import com.csvreader.CsvReader;

public class CsvTool {

	public static List<Branch> getBranchs() {
		List<Branch> branchs = new ArrayList<Branch>();

		try {

			CsvReader file = new CsvReader("branch.csv");

			file.readHeaders();

			while (file.readRecord()) {
				Branch branch = new Branch();

				branch.setNo(file.get("no"));
				branch.setName(file.get("name"));
				branch.setCode(file.get("code"));
				branch.setZipInd(Integer.parseInt(file.get("zipInd")));

				branchs.add(branch);
			}

			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return branchs;
	}

}
