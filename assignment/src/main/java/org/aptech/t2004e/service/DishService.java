package org.aptech.t2004e.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.aptech.t2004e.Dto.DishDto;
import org.aptech.t2004e.entity.Dish;
import org.aptech.t2004e.mapper.DishMapper;
import org.aptech.t2004e.mapper.DishMapperImpl;
import org.aptech.t2004e.repository.DishRepository;
import org.keysoft.JpaRepository.main.impl.Pageable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DishService {
	DishRepository  dishRepository =  new DishRepository() ;
	DishMapperImpl dishMapper = new DishMapperImpl();
	
	public List<DishDto> gets (DishDto criteria){
		// init pageable instance to pagging 
		Pageable pagging = new Pageable(criteria.getPage() , criteria.getSize());
//		List<Dish > lsDish = dishRepository.findAll("" , pagging);
		return dishRepository.findAll("", pagging).stream().map(dishMapper :: entityToDto).collect(Collectors.toList());
	}
	public Boolean add(DishDto dish) {
//		Dish d = dishMapper.dtoToEntity(dish);
//		try {
//			if(!dishRepository.isExist(dish)) {
//				dish.save(d);
//				return true ;
//			}else {
//				return false ;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null ;
	}
}
