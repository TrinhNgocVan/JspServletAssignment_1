package org.keysoft.JpaRepository.main;

import java.sql.ResultSet;
import java.util.List;

import org.keysoft.JpaRepository.main.impl.Pageable;

public interface JpaExecutor<T> {
	List<T> findAll();

	List<T> findAll(String specification,  Pageable p);

	List<T> entityParser(ResultSet resultSet);

}