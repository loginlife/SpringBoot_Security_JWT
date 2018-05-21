package com.huangx.springboot.jwt.controller;

import com.huangx.springboot.jwt.model.Person;
import com.huangx.springboot.jwt.model.ReqPerson;
import com.huangx.springboot.jwt.model.ReturnDto;
import com.huangx.springboot.jwt.enums.RoleEnum;
import com.huangx.springboot.jwt.service.PersonService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.*;

/**
 * Created by Administrator on 2018/5/18.
 */
@RestController
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	/**
	 * User register with whose username and password
	 *
	 * @param reqPerson
	 * @return Success message
	 * @throws ServletException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ReturnDto<String> register(@RequestBody ReqPerson reqPerson) {
		ReturnDto<String> returnDto = new ReturnDto<>();

		try {
			// Check if username and password is null
			if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null
					|| reqPerson.getPassword() == "" || reqPerson.getPassword() == null) {
				throw new ServletException("Username or Password invalid!");
			}

			// Check if the username is used
			if (personService.findPersonByUsername(reqPerson.getUsername()) != null) {
				throw new ServletException("Username is used!");
			}

			// Give a default role : MEMBER
			List<RoleEnum> roles = new ArrayList<>();
			roles.add(RoleEnum.MEMBER);

			// Create a person in ignite
			personService.save(new Person(reqPerson.getUsername(), reqPerson.getPassword(), roles));
			returnDto.setSuccess();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnDto.setError("", e.getMessage());
		}

		return returnDto;
	}

	/**
	 * Check user`s login info, then create a jwt token returned to front end
	 *
	 * @param reqPerson
	 * @return jwt token
	 * @throws ServletException
	 */
	@PostMapping("/login")
	@ResponseBody
	public ReturnDto<String> login(@RequestBody ReqPerson reqPerson) throws ServletException {
		ReturnDto<String> returnDto = new ReturnDto<>();

		try {
			// Check if username and password is null
			if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null
					|| reqPerson.getPassword() == "" || reqPerson.getPassword() == null) {
				throw new ServletException("Please fill in username and password");
			}

			// Check if the username is used
			if (personService.findPersonByUsername(reqPerson.getUsername()) == null
					|| !reqPerson.getPassword().equals(personService.findPersonByUsername(reqPerson.getUsername()).getPassword())) {
				throw new ServletException("Please fill in username and password");
			}

			// Create Twt token
			String jwtToken = Jwts.builder().setSubject(reqPerson.getUsername())
					.claim("roles", "member").setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

			returnDto.setSuccess(jwtToken);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnDto.setError("", e.getMessage());
		}

		return returnDto;
	}

}
