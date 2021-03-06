package com.codegym.project.dish;

import com.codegym.project.IGeneralService;
import com.codegym.project.users.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IDishService extends IGeneralService<Dish> {
    Page<Dish> findAllByNameContaining(String name, Pageable pageable);
    Optional<Dish> findByName(String name);
    Page<Dish> findDishByMerchant(User user, Pageable pageable);
    Page<Dish> findAllByNameContainingAndMerchant(String name, User user, Pageable pageable);
    Page<Dish> findDishByNameContainingAndIdAndMerchant(String name, User user, Pageable pageable, Long id);
    Page<Dish> findByfullname(String name , Pageable pageable);
}
