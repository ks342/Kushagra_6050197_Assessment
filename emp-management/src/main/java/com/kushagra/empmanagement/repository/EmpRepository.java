package com.kushagra.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kushagra.empmanagement.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
}