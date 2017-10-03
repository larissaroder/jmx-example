package br.com.db1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Count implements CountMBean {

	private static List<String> idList = new ArrayList<>();

	private static boolean doLog = true;

	public static void startLog(String id) {
		if (doLog) {
			idList.add(id);
		}
		System.out.println("Start Logging id=" + id);
	}

	@Override
	public boolean getDoLog() {
		return doLog;
	}

	@Override
	public int getListCount() {
		return idList.size();
	}

	@Override
	public void clearList() {
		idList.clear();
	}

	@Override
	public Date getDate() {
		return new Date();
	}

	@Override
	public void changeValue(boolean doLog) {
		this.doLog = doLog;
	}

}
