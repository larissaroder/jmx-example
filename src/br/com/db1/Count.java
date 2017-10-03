package br.com.db1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Count implements CountMBean {

    private static List<String> idList = new ArrayList<>();
    private boolean doLog = true;

    public static void startLog(String id) {
        idList.add(id);
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
    public void clearMap() {
        idList.clear();
    }

    @Override
    public Date getDate() {
        return new Date();
    }

}
