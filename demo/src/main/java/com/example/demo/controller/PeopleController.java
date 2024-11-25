package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

@RestController
public class PeopleController {

	@Autowired
	PersonService personService;
	
	@Autowired
	PersonRepository personRepository;	
	
	

	@PostMapping("/count")
	public String peoplecount() {
		return "welcome people";
	}

	    @GetMapping("/getallpeople")
	    public ResponseEntity<?> getAllPeople() {
	    Map<Integer,List<Person>> personlist = personService.getAllPeople(); 
	    return new ResponseEntity<>(personlist,HttpStatus.OK);	
	    }
	    

	    @GetMapping("/getagelist")
	    public ResponseEntity<?> getAge() {
	    List<Integer> agelist = personService.getAge(); 
	    return new ResponseEntity<>(agelist,HttpStatus.OK);	
	    }
	    

	    @GetMapping("/getmaxage")
	    public ResponseEntity<?> getmaxage() {
	    int maxage = personService.callMaxAge(); 
	    return new ResponseEntity<>(maxage,HttpStatus.OK);	
	    }
	    
	    @GetMapping("/getminage")
	    public ResponseEntity<?> getminage() {
	    int minage = personService.callMinAge(); 
	    return new ResponseEntity<>(minage,HttpStatus.OK);	
	    }
	    
	    // get 2,3 element
	
	    @GetMapping("/skip")
	    public ResponseEntity<?> skip() {
	    List<Integer> minage = personService.skip(); 
	    return new ResponseEntity<>(minage,HttpStatus.OK);	
	    }
	    
	    // uppser case with string seperated by ,
	    @GetMapping("/uppercase")
	    public ResponseEntity<?> uppercase() {
	    String minage = personService.uppercase(); 
	    return new ResponseEntity<>(minage,HttpStatus.OK);	
	    }
	    
	 // returnduplicates
	    @GetMapping("/returnduplicates")
	    public ResponseEntity<?> returnduplicates() {
	    Set<String> returnduplicates = personService.returnduplicates(); 
	    return new ResponseEntity<>(returnduplicates,HttpStatus.OK);	
	    }
	    
	 // returnduplicates other way
	    @GetMapping("/returnduplicates2")
	    public ResponseEntity<?> returnduplicates2() {
	    Set<String> returnduplicates = personService.returnduplicates2(); 
	    return new ResponseEntity<>(returnduplicates,HttpStatus.OK);	
	    }
	    
	 // short and sweet other way
	    @GetMapping("/returnduplicates3")
	    public ResponseEntity<?> returnduplicates3() {
	    List<String> returnduplicates = personService.returnduplicates3(); 
	    return new ResponseEntity<>(returnduplicates,HttpStatus.OK);	
	    }
}
