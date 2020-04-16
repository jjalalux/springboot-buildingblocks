package com.stacksimplify.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ali.moutchou
 *
 */
@RestController
public class HelloWorldController {

	//Simple Method
	// URI - /helloworld
	// GET 
	// @RequestMapping(method = RequestMethod.GET, path ="/helloworld")
	@GetMapping("/helloworld1")
	public String helloWorld() {
		return "Hello World from Rest Controller: HelloWorldController 1 !";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("ali","Moutchou","Rabat");
	}
}
