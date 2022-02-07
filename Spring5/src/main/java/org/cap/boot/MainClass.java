package org.cap.boot;

import org.cap.pojo.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainClass {

	public static void main(String[] args) {
		
		BeanFactory context=
				new XmlBeanFactory(new ClassPathResource("myBeans.xml"));
	
				
		Employee employee=(Employee)context.getBean("employee");
		
		//employee.setFirstName("Paul");
		
		System.out.println(employee);
		//System.out.println(employee1);
		
	}

}
