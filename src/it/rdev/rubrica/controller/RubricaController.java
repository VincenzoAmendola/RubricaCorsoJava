package it.rdev.rubrica.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;
import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;
import it.rdev.rubrica.model.impl.ContactDaoCore;
import it.rdev.rubrica.model.impl.file.ContactDAOFileImpl;
import it.rdev.rubrica.model.impl.rdbms.ContactDAOImpl;


public class RubricaController {
	
	private ContactDAO dao;
	
	public RubricaController() {

		// l'idea è che esca una scelta di questo tipo attraverso il Core 
//		if(Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE).equals("TXT")) {  
			//dao=new ContactDAOFileImpl();
//		}else
//			if(Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE).equals("RDBMS")) {
//				dao = new ContactDAOImpl();	
//			}
		dao	= ContactDaoCore.open();

	}

	public List<Contact> getContactList() {
		return dao.getAll();
	}
	
	public String addContact(Contact c) {
		String view = "LIST";
		try {
			dao.persist(c);
		} catch (SQLException e) {
			e.printStackTrace();
			view = "LIST-ERROR";
		} catch (IOException e) {
			e.printStackTrace();
			view = "LIST-ERROR";
		}
		return view;
	}
	
	public boolean removeContact(Contact c) {
		try {
			return dao.delete(c);
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return false;
	}

}

