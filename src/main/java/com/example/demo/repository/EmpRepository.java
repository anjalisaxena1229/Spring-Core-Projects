package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.*;

//@Repository is not needed because JPA provides @Repossitory annotation

public interface EmpRepository extends JpaRepository<Employee,Integer> { //for CRUD operataion

	
}
