package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PeopleNameService;
import com.example.demo.service.PersonService;

@RestController
public class PeopleNameController {
	
	@Autowired
	PersonService personservice;
	
	@Autowired
	PeopleNameService peoplenameservice;

	 // get name by id or else ananomous
    @GetMapping("/id/{id}")
    public ResponseEntity<?> returnduplicates2(@PathVariable Integer id) {
    String name = peoplenameservice.returnname(id); 
    return new ResponseEntity<>(name,HttpStatus.OK);	
    }
    
	 // get name by id or else ananomous using optional
    @GetMapping("/optionalid/{id}")
    public ResponseEntity<?> optionalreturn(@PathVariable Integer id) {
    	String name = peoplenameservice.optionalreturn(id); 
    return new ResponseEntity<>(name,HttpStatus.OK);		
    }
    
    
    
 
	
}
