package it.rdev.rubrica.model.impl.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;



public class FileSource {
	
		// Singleton because we need only ONE instance of a connection with a file
		private static FileSource fs;
		
		public static FileSource getInstance() {
			if(fs == null) {
				fs = new FileSource();
			}
			return fs;
		}
		
		private static String path;
		private static File file;
		private static BufferedWriter fw;
		
		// The instance opens the file read 
		private FileSource() {
			try {
				FileSource.path = Configuration.getInstance().getValue(
					ConfigKeys.PATH_FILE )
						 +
						 Configuration.getInstance().getValue(
								 ConfigKeys.FILE_NAME);
			File file = new File(path);
			if (file.exists())
			System.out.println("Il file " + path + " esiste");
			else if (file.createNewFile())
			System.out.println("Il file " + path + " è stato creato");
			else
			System.out.println("Il file " + path + " non può essere creato");
			fw = new BufferedWriter(new FileWriter(file));
			} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
		
		public File getFile() {
			return file;
		}
		
		public BufferedWriter getBufferedWriter() {
			return fw;
		}
		
		@Override
		protected void finalize() {
			if( file != null ) {
				try {
					file = null;
					fw.flush();
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}



