package org.panda.mts;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReportService rs = new ReportService();

		Scanner in = new Scanner(System.in);
		String readLine = "";
		printMenu();

		while (!(readLine = in.nextLine()).equals("0")) {
			if (readLine.equals("1")) {
				rs.unzipRequestFiles();
			} else if (readLine.equals("2")) {
				rs.zipResponseFiles();
			} else {
				System.out
						.println("Inputing is error,please reinput No. of Menu");
			}
			printMenu();

		}
		sayGoodBye();
		// ReportService rs = new ReportService();
		// rs.unzipRequestFiles();
	}

	private static void printMenu() {
		System.out.println("###################################");
		System.out.println("#  WELCOME TO BOP&JSH REPORT HELP##");
		System.out.println("###################################");

		System.out.println("1.unzip request file");
		System.out.println("2.zip response file");
		System.out.println("0.exit");

	}

	private static void sayGoodBye() {
		System.out.println("###################################");
		System.out.println("# Thanks for using! GOOD BYE     ##");
		System.out.println("###################################");

	}
}
