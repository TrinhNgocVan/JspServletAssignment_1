package org.aptech.t2004e.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.Data;

@Data
public class AppProperties {
	private int defaultPage ;
	private int defaultPageSize ;	
	private String email ;
	private String databaseAction;
	private String databaseName  ; 
	public AppProperties() {
		super();		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    	InputStream input = classLoader.getResourceAsStream("application.properties");    	
    	try {
    	Properties properties = new Properties() ;
    	properties.load(input);
    	this.defaultPage = Integer.parseInt(properties.getProperty("app.default-page").trim());
    	this.defaultPageSize = Integer.parseInt(properties.getProperty("app.default-page-size").trim());
    	this.databaseAction = properties.getProperty("database.action").trim();
    	this.databaseName = properties.getProperty("database.name").trim();
		} catch (IOException e ) {
			System.err.println("Cannot read file properties \n");
			e.printStackTrace();			
		}
	}
	
	
	
}
