package br.com.db1.control;

import br.com.db1.Count;
import br.com.db1.CountMBean;
import br.com.db1.Main;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

public final class ControlCount {

	private static final String JMX_REGISTER = "br.com.db1:type=Count";

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	private ControlCount() {
	}

	public static void controlCount(Integer id, CountMBean mbean) {
		while (id < 100) {
			try {
				Count.startLog(String.valueOf(id));
				Thread.sleep(5000);
				if (mbean.getDoLog()) {
					id++;
				}
			} catch (InterruptedException e) {
				LOGGER.info(e.getMessage());
			}
		}
	}

	public static CountMBean registerCountMBean() {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		CountMBean mbean = new Count();
		try {
			ObjectName name = new ObjectName(JMX_REGISTER);
			mbs.registerMBean(mbean, name);
		} catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
			LOGGER.info(e.getMessage());
		}
		return mbean;
	}
}
