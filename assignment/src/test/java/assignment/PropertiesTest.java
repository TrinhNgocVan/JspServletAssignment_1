package assignment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.aptech.t2004e.config.AppProperties;
import org.aptech.t2004e.entity.Dish;
import org.junit.jupiter.api.Test;
import org.keysoft.JpaRepository.anotation.clazz.Product;
import org.keysoft.JpaRepository.databaseconfig.DatabaseConfig;
import org.keysoft.JpaRepository.helper.DatabaseHelper;
import org.keysoft.JpaRepository.main.impl.JpaRepositoryExecutorImpl;
import org.keysoft.JpaRepository.main.impl.Pageable;

public class PropertiesTest {
	public static void main(String[] args ) throws IOException {
		
		JpaRepositoryExecutorImpl<Dish> productRepository = new JpaRepositoryExecutorImpl<>(Dish.class);
		Pageable pagging = new Pageable(1 , 5);
        System.err.println(productRepository.findAll("" ,pagging));
		
		
	}

}
