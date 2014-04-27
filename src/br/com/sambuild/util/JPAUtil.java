package br.com.sambuild.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf = Persistence
	    .createEntityManagerFactory("lulu");

    public EntityManager getEntityManager() {
	return emf.createEntityManager();
    }

}