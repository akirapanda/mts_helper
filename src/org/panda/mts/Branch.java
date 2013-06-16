package org.panda.mts;

public class Branch {
	private String no;
	private String name;
	private String code;
	private int zipInd;

	public static int ZIP_IND_NO_FOLDER = 0;
	public static int ZIP_IND_NEED_FOLDER = 1;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getZipInd() {
		return zipInd;
	}

	public void setZipInd(int zipInd) {
		this.zipInd = zipInd;
	}

}
