package br.com.db1;

import java.lang.management.ManagementFactory;
import java.util.stream.IntStream;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class Main {

    private static final String JMX_REGISTER = "br.com.db1:type=Count";

    public static void main(String[] args) {

        int id = 0;

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        CountMBean mbean = new Count();
        try {
            ObjectName name = new ObjectName(JMX_REGISTER);
            mbs.registerMBean(mbean, name);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e1) {
            e1.printStackTrace();
        }

        IntStream.range(0, 11)
                .forEach(idx -> {
                    try {
                        Count.startLog(String.valueOf(idx));
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
