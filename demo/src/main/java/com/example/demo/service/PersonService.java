package com.example.demo.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Map<Integer, List<Person>>  getAllPeople() {
    	
    	Map<Integer, List<Person>> personmap = 
    			personRepository.findAll().stream().collect(Collectors.groupingBy(
    					emp->emp.getAge()));
    	
        return personmap;
    }

	public List<Integer> getAge() {
		List<Integer> age =  personRepository.findAll().stream().map(emp->emp.getAge())
		.collect(Collectors.toList());
		return age;
	}
	
	public int callMaxAge() {
		List<Integer> age =  personRepository.findAll().stream().map(emp->emp.getAge())
		.collect(Collectors.toList());
		
		int maxAge = age.stream().mapToInt(x->x).summaryStatistics().getMax();
		return maxAge;
		
	}
	
	public int callMinAge() {
		List<Integer> age =  personRepository.findAll().stream().map(emp->emp.getAge())
		.collect(Collectors.toList());
		
		int minAge = age.stream().mapToInt(x->x).summaryStatistics().getMin();
		return minAge;
	}
	
	public List<Integer> skip() {
		List<Integer> age =  personRepository.findAll().stream().map(emp->emp.getAge())
		.sorted().collect(Collectors.toList());
		
		List<Integer> skip = age.stream().skip(1).limit(2).collect(Collectors.toList()); 
		return skip;
	}
	
	public String uppercase() {
		List<String> namelist =  personRepository.findAll().stream().map(emp->emp.getName())
		.collect(Collectors.toList());
		
		String namestring = namelist.stream().collect(Collectors.joining(",  ")); 
		return namestring;
	}
	
	public Set<String> returnduplicates() {
		List<String> namelist =  personRepository.findAll().stream().map(emp->emp.getName())
		.collect(Collectors.toList());
		
		Set<String> uniqueNames = new HashSet<>();				
		Set<String> namestring = namelist.stream().filter(name ->!uniqueNames.add(name)).collect(Collectors.toSet()); 
		return namestring;
	}
	
	public Set<String> returnduplicates2() {
		List<String> namelist =  personRepository.findAll().stream().map(emp->emp.getName())
		.collect(Collectors.toList());
		
		Map<String, Long> dupnames = namelist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Set<String> dupname =  dupnames.entrySet().stream().filter(entry -> entry.getValue()>1).map(entry-> entry.getKey()).collect(Collectors.toSet());
		
		return dupname;
	}
	
	public List<String> returnduplicates3() {
		List<String> namelist =  personRepository.findAll().stream().map(emp->emp.getName())
		.collect(Collectors.toList());
		
		
		List<String> dupname = namelist.stream().filter( 
				name -> Collections.frequency(namelist,name)>1).collect(Collectors.toList());
		
		return dupname;
	}
}
