package org.panda.mts.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private Properties propertie;
	private FileInputStream inputFile;

	public Config() {
		propertie = new Properties();
	}

	public Config(String filePath) {
		propertie = new Properties();
		try {
			inputFile = new FileInputStream(filePath);
			propertie.load(inputFile);
			inputFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("��ȡ�����ļ�--->ʧ�ܣ�- ԭ���ļ�·����������ļ�������");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("װ���ļ�--->ʧ��!");
			ex.printStackTrace();
		}
	}

	public String getValue(String key) {
		if (propertie.containsKey(key)) {
			String value = propertie.getProperty(key);// �õ�ĳһ���Ե�ֵ
			return value;
		} else
			return "";
	}
}
