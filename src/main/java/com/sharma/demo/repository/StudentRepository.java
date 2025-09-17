package com.sharma.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharma.demo.entity.Student;
@Repository //we used in in dao  but now we using jpa its also a technique to perform database operation
public interface StudentRepository extends JpaRepository<Student,Integer>{//student is my entity class and id type Integer

}
