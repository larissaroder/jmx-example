package br.com.db1;

import java.util.Date;

public interface CountMBean {
    public boolean getDoLog();

    public int getListCount();

    public void clearMap();

    Date getDate();
}
