package org.aptech.t2004e.repository;

import org.aptech.t2004e.entity.Dish;
import org.keysoft.JpaRepository.main.impl.JpaRepositoryExecutorImpl;

public class DishRepository extends JpaRepositoryExecutorImpl<Dish> {

	public DishRepository() {
		super(Dish.class);
	}
}
