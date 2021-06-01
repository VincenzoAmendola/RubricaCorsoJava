package it.rdev.rubrica.model;

import java.io.IOException;
import java.sql.SQLException;


public interface DAO<T> {
	
	boolean persist(T t) throws IOException, SQLException;
	
	boolean delete(T t) throws IOException, SQLException;
	
	boolean update(T t) throws IOException, SQLException;
	
}
