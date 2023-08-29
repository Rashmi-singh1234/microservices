package com.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer>{
    
	
	public AppUser findByUserName(String userName);
}
