package com.huangx.springboot.jwt.service.impl;

import com.huangx.springboot.jwt.dao.PersonRepository;
import com.huangx.springboot.jwt.model.Person;
import com.huangx.springboot.jwt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements interface PersonService
 *
 * Created by Administrator on 2018/5/18.
 **/
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Save Person to Ignite DB
	 *
	 * @param person Person object.
	 * @return The Person object saved in Ignite DB.
	 */
	public Person save(Person person) {
		// If this username is not used then return null,
		// if is used then return this Person
		return personRepository.save(person.getId(), person);
	}

	/**
	 * Find a Person from Ignite DB with given name.
	 *
	 * @param name Person name.
	 * @return The person found in Ignite DB
	 */
	public Person findPersonByUsername(String name) {
		return personRepository.findByUsername(name);
	}

	public List<Person> findAll() {
		List<Person> list = new ArrayList<>();
		Iterable<Person> iterable = personRepository.findAll();
		for ( Person p : iterable ) {
			list.add(p);
		}
		return list;
	}

}
