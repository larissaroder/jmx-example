package br.com.db1;

import java.util.Date;

public interface CountMBean {
	boolean getDoLog();

	int getListCount();

	void clearList();

	Date getDate();

	void changeValue(boolean doLog);
}
