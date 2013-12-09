package org.hibernate.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

	public class HibernateUtil {

	    private static final SessionFactory sessionFactory = buildSessionFactory();
	    private static Session session = null;
	    
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
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
	    		configuration.setProperty("hibernate.show_sql", "true");
	    		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
	    		
	    		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
	    				.applySettings(configuration.getProperties())
	    				.buildServiceRegistry();
	    		return configuration.buildSessionFactory(serviceRegistry);
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    public static Session getSession() {
	    	if (session == null){
	    		session = sessionFactory.openSession();
	    	}
	        return session;
	    }

	}

