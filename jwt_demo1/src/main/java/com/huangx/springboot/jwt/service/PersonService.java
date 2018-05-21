package com.huangx.springboot.jwt.service;

import com.huangx.springboot.jwt.model.Person;

import java.util.List;

/**
 * Interface for handling SQL operator in PersonCache
 *
 * Created by Administrator on 2018/5/18.
 **/
public interface PersonService {

	/**
	 * @param person Person Object
	 * @return The Person object saved in Ignite DB.
	 */
	Person save(Person person);

	/**
	 * Find a Person from Ignite DB with given name.
	 *
	 * @param name Person name.
	 * @return The person found in Ignite DB
	 */
	Person findPersonByUsername(String name);

	/**
	 * Find all Person from Ignite DB.
	 * @return
	 */
	List<Person> findAll();

}
