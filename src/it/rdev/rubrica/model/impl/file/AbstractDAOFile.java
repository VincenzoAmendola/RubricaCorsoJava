package it.rdev.rubrica.model.impl.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.DAO;

public abstract class AbstractDAOFile<T> implements DAO<T> {

	protected boolean writeInFile(String s) throws IOException {
		try {FileSource.getInstance().getBufferedWriter().write(s);
		
		}catch(IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	protected boolean deleteFromFile(Contact t) throws IOException{
		try{
			File tempfile = new File("C:\\Users\\Utente\\Documents\\temp.txt");
			BufferedReader reader = new BufferedReader(new FileReader(tempfile));
			String lineToRemove = t.getName()+	", "	+	
			t.getSurname()	+	", "	+	
			t.getPhoneNumbers()	+	", " +
			t.getEmails();
			
			String currentLine;
			while((currentLine = reader.readLine()) !=	null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equalsIgnoreCase(lineToRemove)) {
					continue;
				}
				writeInFile(currentLine);
				FileSource.getInstance().getBufferedWriter().newLine();
			}
			reader.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

//	private void copy() {
//		File tempfile = new File("C:\\Users\\Utente\\Documents\\temp.txt");
//		try {
//			BufferedReader = new BufferedReader(new FileReader(tempfile));
//		}
//		
//	}
//}
	
}
