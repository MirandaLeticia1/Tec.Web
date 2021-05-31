package br.com.bank.util;

import javax.servlet.ServletContextListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;


public class AppServletContextListener implements ServletContextListener {
    private static EntityManagerFactory emf;

    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory("acme");
        createEntityManager();
    }

    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return emf.createEntityManager();
    }
}
