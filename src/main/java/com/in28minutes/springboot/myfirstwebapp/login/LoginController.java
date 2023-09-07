package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	public LoginController(AuthenticationService autheticationService) {
		super();
		this.autheticationService = autheticationService;
	}
	private AuthenticationService autheticationService;
	
	//http://localhost:8080/login
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		
		return "login";
	}
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(autheticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}
		model.put("errormessage", "Invalid Credentials");
		return "login";
	}
}
