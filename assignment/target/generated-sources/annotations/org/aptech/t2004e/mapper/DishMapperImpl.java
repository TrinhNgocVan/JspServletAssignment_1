package org.aptech.t2004e.mapper;

import org.aptech.t2004e.Dto.DishDto;
import org.aptech.t2004e.entity.Dish;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-24T21:04:23+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 16.0.2 (Oracle Corporation)"
)
*/
public class DishMapperImpl implements DishMapper {

    @Override
    public DishDto entityToDto(Dish dish) {
        if ( dish == null ) {
            return null;
        }

        DishDto dishDto = new DishDto();

        dishDto.setCategoryCode( dish.getCategoryCode() );
        dishDto.setCode( dish.getCode() );
        dishDto.setDescription( dish.getDescription() );
        dishDto.setId( dish.getId() );
        dishDto.setImageUrl( dish.getImageUrl() );
        dishDto.setName( dish.getName() );
        dishDto.setPrice( dish.getPrice() );
        dishDto.setStarteddate( dish.getStarteddate() );
        dishDto.setStatus( dish.getStatus() );
        dishDto.setUpdatedDate( dish.getUpdatedDate() );

        return dishDto;
    }

    @Override
    public Dish dtoToEntity(DishDto dishDto) {
        if ( dishDto == null ) {
            return null;
        }

        Dish dish = new Dish();

        dish.setCategoryCode( dishDto.getCategoryCode() );
        dish.setCode( dishDto.getCode() );
        dish.setDescription( dishDto.getDescription() );
        dish.setId( dishDto.getId() );
        dish.setImageUrl( dishDto.getImageUrl() );
        dish.setName( dishDto.getName() );
        dish.setPrice( dishDto.getPrice() );
        dish.setStarteddate( dishDto.getStarteddate() );
        dish.setStatus( dishDto.getStatus() );
        dish.setUpdatedDate( dishDto.getUpdatedDate() );

        return dish;
    }
}
