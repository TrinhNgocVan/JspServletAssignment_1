package org.aptech.t2004e.entity;

import java.time.LocalDate;

import org.keysoft.JpaRepository.anotation.clazz.Table;
import org.keysoft.JpaRepository.anotation.field.Column;
import org.keysoft.JpaRepository.anotation.field.Id;
import org.keysoft.JpaRepository.consts.SQLDataTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "dish_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
	@Id(autoIncrement = true)
	@Column(name = "id",type =SQLDataTypes.INTEGER  )
	private int id ;
	@Column(name = "dish_name",type =SQLDataTypes.VARCHAR255 )
	private String name ;
	@Column(name = "dish_code",type =SQLDataTypes.VARCHAR255 )
	private String code ;	
	@Column(name = "category_code",type =SQLDataTypes.VARCHAR50 )
	private String categoryCode ;
	@Column(name = "description",type =SQLDataTypes.TEXT )
	private String description ;
	@Column(name = "image_url",type =SQLDataTypes.VARCHAR255 )
	private String imageUrl ;
	@Column(name = "dish_price",type =SQLDataTypes.INTEGER )
	private int price ;
	@Column(name = "started_date",type =SQLDataTypes.TEXT )
	private String  starteddate ;	
	@Column(name = "updated_Date",type =SQLDataTypes.TEXT )
	private  String updatedDate ;
	@Column(name = "status",type =SQLDataTypes.VARCHAR50)
	private String status ;
	
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + "]";
	}
}