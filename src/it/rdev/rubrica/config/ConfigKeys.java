package it.rdev.rubrica.config;

public enum ConfigKeys {
	
	APP_NAME("app-name"),
	DB_HOST("app.db.host"),
	DB_PORT("app.db.port"),
	DB_NAME("app.db.name"),
	DB_USER("app.db.username"),
	DB_PASS("app.db.password"),
	DB_CLASS("app.db.driver.class"),
	PERSISTENCE_TYPE("Persistence-type"),
	PATH_FILE("app.file.pathfile"),
	FILE_NAME("app.file.name");
	
	
	private String key;
	
	ConfigKeys(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}

}
