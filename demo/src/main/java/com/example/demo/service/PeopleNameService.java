package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PeopleNameService {

	@Autowired
	PersonRepository person;
	
//	
//    private final PersonRepository personRepository;
//
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//	
    
    public String returnname(int id) {
    	Optional<Person> e = person.findById((long) id);
    	
    		String name = Optional.ofNullable(e.get().getName())
        			.orElse("ananomous");
    		return name;    	   
    }
    
    public String optionalreturn(int id) {
    	Optional<Person> e = person.findById((long) id);
    	if(!e.isEmpty()) {
    		Optional<String> name = Optional.ofNullable(e.get().getName());
//    		if(name.isPresent()) {
//    			String upercasename = name.get().toUpperCase();
//    			return upercasename;
//    		}else{
//    			return "name is null";
//    		}
    		
    		name.ifPresentOrElse(n -> System.out.print(n.toUpperCase()), ()->{System.out.println("name is null");});
    	}else {
    	return "emp is not present in DB";
    	}
		return null;    	   
    }
    
    
    
}
