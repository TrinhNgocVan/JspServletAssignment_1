package org.aptech.t2004e.mapper;

import org.aptech.t2004e.Dto.DishDto;
import org.aptech.t2004e.entity.Dish;
import org.mapstruct.Mapper;

@Mapper
public interface DishMapper {
	DishDto entityToDto (Dish dish);
	Dish   dtoToEntity (DishDto dishDto);
}
