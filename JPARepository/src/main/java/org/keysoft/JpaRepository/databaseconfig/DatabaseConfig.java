package org.keysoft.JpaRepository.databaseconfig;

public class DatabaseConfig {
	private static final String DB_URL = "jdbc:mysql://localhost:5200/demo_db?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USERNAME =  "root";
    private static final String   PASSWORD = "Root@123";

    public static String getDB_URL() {
        return DB_URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }
}
