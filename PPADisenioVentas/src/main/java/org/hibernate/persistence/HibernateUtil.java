package org.hibernate.persistence;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.addResource("hibernate-mapping.xml");
		configuration.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class",
				"com.mysql.jdbc.Driver");
		
		configuration.setProperty("hibernate.connection.url",
				"jdbc:mysql://localhost:3306/ppa_disenio");
		configuration.setProperty("hibernate.transaction.factory_class",
				"org.hibernate.transaction.JDBCTransactionFactory");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.order_updates", "true");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		return configuration.buildSessionFactory(serviceRegistry);

	}

	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}
