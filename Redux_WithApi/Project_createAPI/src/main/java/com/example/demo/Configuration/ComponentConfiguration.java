package com.example.demo.Configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyDTO;

@Configuration
public class ComponentConfiguration {
	@Bean
	 public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        
    	modelMapper.addMappings(new PropertyMap<Company, CompanyDTO>() {
			@Override
			protected void configure() {
//				map().setIdcom(source.g());
//				map().setCompanyname(source.getCompanyname());
//				map().setEmployees(source.getEmployees());

			}
		});
    	return modelMapper;
	}
}
