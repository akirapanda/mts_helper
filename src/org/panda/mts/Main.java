package org.panda.mts;

import java.util.Scanner;

import org.panda.mts.util.Config;

public class Main {

	private static Config cf = new Config("config.property");
	private final static String BOP_UNZIP_SOURCE_PATH = cf
			.getValue("BOP_UPLOAD_ZIP_PATH");
	private final static String BOP_UNZIP_TAGGET_PATH = cf
			.getValue("BOP_UPLOAD_UNZIP_PATH");

	private final static String BOP_ZIP_SOURCE_PATH = cf
			.getValue("BOP_DOWNLOAD_SOURCE_PATH");
	private final static String BOP_ZIP_TARGET_PATH = cf
			.getValue("BOP_DOWNLOAD_TARGET_PATH");

	private final static String JSH_UNZIP_SOURCE_PATH = cf
			.getValue("JSH_UPLOAD_ZIP_PATH");
	private final static String JSH_UNZIP_TAGGET_PATH = cf
			.getValue("JSH_UPLOAD_UNZIP_PATH");

	private final static String JSH_ZIP_SOURCE_PATH = cf
			.getValue("JSH_DOWNLOAD_SOURCE_PATH");
	private final static String JSH_ZIP_TARGET_PATH = cf
			.getValue("JSH_DOWNLOAD_TARGET_PATH");

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
				rs.unzipRequestFiles(BOP_UNZIP_SOURCE_PATH,
						BOP_UNZIP_TAGGET_PATH);
			} else if (readLine.equals("2")) {
				rs.zipResponseFiles(BOP_ZIP_SOURCE_PATH, BOP_ZIP_TARGET_PATH);
			} else if (readLine.equals("3")) {
				rs.unzipRequestFiles(JSH_UNZIP_SOURCE_PATH,
						JSH_UNZIP_TAGGET_PATH);
			} else if (readLine.equals("4")) {
				rs.zipResponseFiles(JSH_ZIP_SOURCE_PATH, JSH_ZIP_TARGET_PATH);
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
		System.out.println("");
		System.out.println("*PART A* BOP");
		System.out.println("1.unzip request file");
		System.out.println("2.zip response file");
		System.out.println("*PART B* JSH");
		System.out.println("3.unzip request file");
		System.out.println("4.zip response file");
		System.out.println("0.exit");

	}

	private static void sayGoodBye() {
		System.out.println("###################################");
		System.out.println("# Thanks for using! GOOD BYE     ##");
		System.out.println("###################################");

	}
}
