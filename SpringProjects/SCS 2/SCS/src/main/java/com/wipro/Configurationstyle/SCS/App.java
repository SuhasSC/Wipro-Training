package com.wipro.Configurationstyle.SCS;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		/*
		 * In XML based config style where we have called applicationContext.xml file in
		 * ClassPathXmlApplicationContext>
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// ask the container or spring to get the delegate bean or object

		DelegateXMLBased delegate = context.getBean("delegate", DelegateXMLBased.class);
		delegate.notifyUser();

		// shut down the container
		((ClassPathXmlApplicationContext) context).close();
	}
}