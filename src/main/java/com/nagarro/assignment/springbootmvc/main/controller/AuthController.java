package com.nagarro.assignment.springbootmvc.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.assignment.springbootmvc.main.services.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService authservice;

	@RequestMapping("/")
	public String showLogin() {
		return "index";
	}

	@RequestMapping(value = "/loginform", method = RequestMethod.POST)
	public String loginForm(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response, Model m) {
		
		boolean authenticated = this.authservice.getUser(username, password);
		System.out.println(authenticated);
		
		String redirect = null;
	
		if (authenticated) {
			HttpSession s = request.getSession();

			s.setMaxInactiveInterval(30 * 60);
			s.setAttribute("username", username);
			Cookie userName = new Cookie("username", username);
			response.addCookie(userName);

			m.addAttribute("username",username);
			redirect = "redirect:/dashboard";
			
		}else {
			m.addAttribute("errorMsg", "Username and password does not match.");
			redirect = "index";
		
		}

		return redirect;
	}
	
	
	@RequestMapping(path = "/logoutForm", method = RequestMethod.POST)
	public String logoutForm(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					break;
				}
			}
		}
		
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
