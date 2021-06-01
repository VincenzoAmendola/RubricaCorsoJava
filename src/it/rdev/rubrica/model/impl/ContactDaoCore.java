package it.rdev.rubrica.model.impl;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;
import it.rdev.rubrica.model.ContactDAO;
import it.rdev.rubrica.model.impl.file.ContactDAOFileImpl;
import it.rdev.rubrica.model.impl.rdbms.ContactDAOImpl;


public class ContactDaoCore {
		
		private static ContactDaoCore instance;
		private static String persistenceType = Configuration.getInstance().getValue(
				ConfigKeys.PERSISTENCE_TYPE);;
		
		public static ContactDaoCore getInstance() {
			if(instance == null) {
				instance = new ContactDaoCore();
			}
			return instance;
		}
		
		private ContactDaoCore() {
		}
		
		public String getPersistenceType() {
			return persistenceType;
		}
		
		public static ContactDAO open() {
			ContactDAO dao = null;
			try {
				if(ContactDaoCore.persistenceType.equals("TXT")) {
					dao= new ContactDAOFileImpl();
				}
					else if(ContactDaoCore.persistenceType.equals("RDBMS")){
						dao=new ContactDAOImpl();
					}
				// The default dao is the file One
				if(dao==null) {
					return dao= new ContactDAOFileImpl();
				}
			} catch(Exception e) {
				e.printStackTrace();
			} 
			return dao;
		}
		
	}

