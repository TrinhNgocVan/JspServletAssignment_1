package org.aptech.t2004e.config;

import org.aptech.t2004e.entity.Dish;
import org.keysoft.JpaRepository.helper.DatabaseHelper;
import org.keysoft.JpaRepository.main.impl.JpaRepositoryExecutorImpl;

public class SetupDatabase {
	AppProperties appProperties = new AppProperties() ;
	DatabaseHelper dbHelper = new DatabaseHelper() ;
	
	public static void main(String[] args) {
		SetupDatabase obj = new SetupDatabase();
		obj.initDb();
		
	}
	public   void initDb() {
//		dbHelper.createDb(appProperties.getDatabaseName());
		JpaRepositoryExecutorImpl<Dish> dishRepo = new JpaRepositoryExecutorImpl<>(Dish.class);
		if(appProperties.getDatabaseAction().toLowerCase().equals("create")) {
			dishRepo.createTable();
		}
		if(appProperties.getDatabaseAction().toLowerCase().equals("update")) {
			dishRepo.updateTable();
		}
			
	}
}
