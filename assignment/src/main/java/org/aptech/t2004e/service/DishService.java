package org.aptech.t2004e.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aptech.t2004e.dto.DishDto;
import org.aptech.t2004e.dto.PageDto;
import org.aptech.t2004e.entity.Dish;
import org.aptech.t2004e.mapper.DishMapperImpl;
import org.aptech.t2004e.repository.DishRepository;
import org.keysoft.JpaRepository.anotation.domain.Page;
import org.keysoft.JpaRepository.main.impl.Pageable;

public class DishService {
	DishRepository  dishRepository =  new DishRepository() ;
	DishMapperImpl dishMapper = new DishMapperImpl();
	
	public Page<Dish> gets (DishDto criteria){
		// init pageable instance to pagging 
		Pageable pagging = new Pageable(criteria.getPage() , criteria.getSize());
		Page<Dish> dishs = dishRepository.findAll("", pagging);
		return dishs ;
	}
	public DishDto get(int  id) {
		return  dishRepository.findById(id).map(dishMapper :: entityToDto).orElse(null) ;
	}
	public Boolean save(DishDto dish) {
	Dish d = dishMapper.dtoToEntity(dish);
	if(d.getId() == 0) {
		dishRepository.save(d);
	}else {
		dishRepository.update(d.getId(), d);
	}
		return true ;
	}
}
