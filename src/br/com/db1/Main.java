package br.com.db1;

import br.com.db1.control.ControlCount;

public class Main {

	public static void main(String[] args) {

		Integer id = 0;
		CountMBean mbean = ControlCount.registerCountMBean();
		ControlCount.controlCount(id, mbean);
	}

}
