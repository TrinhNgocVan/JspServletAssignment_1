package org.keysoft.JpaRepository.main.impl;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.keysoft.JpaRepository.Product;
import org.keysoft.JpaRepository.Helper.DatabaseHelper;
import org.keysoft.JpaRepository.Helper.DateTimeHelper;
import org.keysoft.JpaRepository.anotation.clazz.Entity;
import org.keysoft.JpaRepository.anotation.field.Column;
import org.keysoft.JpaRepository.consts.SQLDataTypeEnum;
import org.keysoft.JpaRepository.consts.SQLDataTypes;
import org.keysoft.JpaRepository.consts.SqlStatementEnum;
import org.keysoft.JpaRepository.main.JpaExecutor;

public class JpaRepositoryExecutorImpl<T> extends DatabaseHelper implements JpaExecutor<T>   {	
	private Class<T> clazz ;
	private String className ;
	public String tableName ;
	public JpaRepositoryExecutorImpl(Class<T> clazz  ) {
		this.clazz = clazz ;
		this.className = clazz.getSimpleName();
		this.tableName = (clazz.getAnnotation(Entity.class) != null ) ? clazz.getAnnotation(Entity.class).tablename()
																					: this.className ;
	}
	@Override
	public List<T> findAll()  {
		try {
			Connection connection = getConnection();
			StringBuilder statement = new StringBuilder();
			statement.append(SqlStatementEnum.SELECT_ASTERISK.value).append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.FROM)
						.append(SqlStatementEnum.SPACE.value).append(tableName) ;
			/*
			 * Execute command
			 */
			 PreparedStatement preparedStatement = connection.prepareStatement(statement.toString());
			 ResultSet rs = preparedStatement.executeQuery();
			 return  entityParser(rs);
		} catch ( SQLException |IllegalArgumentException e ) {
			e.printStackTrace();
			return null ;
		}	
	}
	@Override
	public List<T> findAll(String specification ,Pageable p){
		try {
			StringBuilder statement = new StringBuilder();
			statement.append(SqlStatementEnum.SELECT_ASTERISK.value).append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.FROM)
						.append(SqlStatementEnum.SPACE.value).append(tableName)
						// append filter to sql
						.append(SqlStatementEnum.SPACE.value).append(specification)
						// append paging to sql					
						.append(SqlStatementEnum.DOWN_LINE.value)
						.append(SqlStatementEnum.MULTIPLE_SPACE.value).append(SqlStatementEnum.LIMIT.value).append(SqlStatementEnum.SPACE.value)
						.append(Integer.toString(p.getSize()))
						.append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.OFFSET.value).append(SqlStatementEnum.SPACE.value)
						.append(Integer.toString(p.getSize()*(p.getPage() -1)));	
			/*
			 * Execute command
			 */
			 Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(statement.toString());
			 ResultSet rs = preparedStatement.executeQuery();
			 return entityParser(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}		
	}	
	@Override
	public  List<T> entityParser(ResultSet resultSet)  {
		ArrayList<T> lsEntitys = new ArrayList<T>();
		
		try {
			 while (resultSet.next()) {
		            T entity = clazz.getDeclaredConstructor().newInstance();
		            for (Field field : clazz.getDeclaredFields()) {
		                String columnName = field.getName().toLowerCase();
		                if (field.isAnnotationPresent(Column.class)  && StringUtils.isNoneBlank(field.getAnnotation(Column.class).name())) {
		                    Column columnInfor = field.getAnnotation(Column.class);
		                    columnName = columnInfor.name();		                    
		                    field.setAccessible(true);
		                    switch (columnInfor.type()) {
		                        case SQLDataTypes.INTEGER:
		                            field.set(entity, resultSet.getInt(columnName));
		                            break;
		                        case SQLDataTypes.TEXT:
		                            field.set(entity, resultSet.getString(columnName));
		                            break;
		                        case SQLDataTypes.DOUBLE:
		                            field.set(entity, resultSet.getDouble(columnName));
		                            break;
		                        case SQLDataTypes.DATE:
		                            field.set(entity, DateTimeHelper.convertSqlDateToJavaDate(resultSet.getDate(columnName)));
		                            break;
		                        case SQLDataTypes.DATETIME:
		                        case SQLDataTypes.TIME_STAMP:
		                            field.set(entity, DateTimeHelper.convertSqlTimeStampToJavaDate(resultSet.getTimestamp(columnName)));
		                            break;
		                    }
		                }
		            }
//		            Arrays.asList(clazz.getDeclaredFields()).stream().forEach( f -> {		            	
//		            	if(f.isAnnotationPresent(Column.class) && StringUtils.isNotEmpty(f.getName())) {
//		            		String columnName = f.getName();
//		            		f.setAccessible(true);
//		            		Arrays.asList(SQLDataTypeEnum.values()).stream().findAny(f.getType())
//		            	}
//		            });
		         lsEntitys.add(entity); 
			 }
						
		} catch (InstantiationException | IllegalAccessException | SQLException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}     
        return lsEntitys;
    }

	
}
