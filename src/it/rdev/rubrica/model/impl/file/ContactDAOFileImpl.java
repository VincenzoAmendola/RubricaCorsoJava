package it.rdev.rubrica.model.impl.file;


import java.io.IOException;
import java.util.List;

import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;

public class ContactDAOFileImpl extends AbstractDAOFile<Contact> implements ContactDAO{

	@Override
	public boolean persist(Contact t) throws IOException {
		writeInFile(t.toString());
		return false;
	}

	@Override
	public boolean delete(Contact t) throws IOException {
		
		return false;
	}

	@Override
	public boolean update(Contact t) throws IOException {
		
		return false;
	}

	@Override
	public List<Contact> getAll() {
		
		return null;
	}

}
