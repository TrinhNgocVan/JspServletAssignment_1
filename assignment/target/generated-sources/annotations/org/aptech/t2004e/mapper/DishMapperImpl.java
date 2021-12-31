package org.aptech.t2004e.mapper;

import org.aptech.t2004e.dto.DishDto;
import org.aptech.t2004e.dto.DishDto.DishDtoBuilder;
import org.aptech.t2004e.entity.Dish;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-31T17:30:59+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 16.0.2 (Oracle Corporation)"
)
*/
public class DishMapperImpl implements DishMapper {

    @Override
    public DishDto entityToDto(Dish dish) {
        if ( dish == null ) {
            return null;
        }

        DishDtoBuilder dishDto = DishDto.builder();

        dishDto.categoryCode( dish.getCategoryCode() );
        dishDto.code( dish.getCode() );
        dishDto.description( dish.getDescription() );
        dishDto.id( dish.getId() );
        dishDto.imageUrl( dish.getImageUrl() );
        dishDto.name( dish.getName() );
        dishDto.price( dish.getPrice() );
        dishDto.starteddate( dish.getStarteddate() );
        dishDto.status( dish.getStatus() );
        dishDto.updatedDate( dish.getUpdatedDate() );

        return dishDto.build();
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
