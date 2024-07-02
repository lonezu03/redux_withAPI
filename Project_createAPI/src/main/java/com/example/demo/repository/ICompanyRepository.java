package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Company;

public interface ICompanyRepository  extends JpaRepository<Company, Integer>{


}
