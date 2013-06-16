package org.panda.mts;

import java.io.File;

public class FileChecker {
	public static void main(String args[]) {
		File f = null;
		f = new File("C:\\testabc");
		printFile(f);
	}

	public static void printFile(File f) {
		File[] list = f.listFiles();
		for (File subFile : list) {
			if (subFile.isDirectory()) {
				printFile(subFile);
			} else {
				System.out.println(subFile.getName());
			}
		}
	}
}