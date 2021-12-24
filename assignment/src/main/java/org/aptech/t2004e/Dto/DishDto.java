package org.aptech.t2004e.Dto;

import java.time.LocalDate;

import org.keysoft.JpaRepository.main.impl.Pageable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class DishDto extends Pageable{
	private int id ;
	private String name ;
	private String code ;	
	private String categoryCode ;
	private String imageUrl ;
	private int price ;
	private LocalDate starteddate ;	
	private  LocalDate updatedDate ;
	private String status ;
	private String description ;
}
