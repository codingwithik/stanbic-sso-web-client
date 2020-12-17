package com.stanbicibtc.webpoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stanbicibtc.webpoc.entities.User;
import com.stanbicibtc.webpoc.pojo.ResponseDTO;
import com.stanbicibtc.webpoc.services.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, BindingResult bindingResult) {
	    
        userService.save(user);
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "/login";
    }
    
    @GetMapping("/registration")
    public String registration() {
        return "/registration";
    }
    
    @GetMapping("/link_profile")
    public String linkProfile() {
        return "/link_profile";
    }
    
    @GetMapping("/book_login")
    public String bookLogin() {
        return "/book_login";
    }
    
    @GetMapping("/poc_login")
    public String pocLogin() {
        return "/poc_login";
    }
    
    @PostMapping("/login")
	public String doLogin(String username, String password, RedirectAttributes redirectAttributes, Model model) {
		System.out.println("Intiating Do Login");
		
		try {
			ResponseDTO response = userService.doLogin(username, password);
			if(response.getData() != null) {
				User user = userService.findByEmail(username);
				model.addAttribute("username", "Welcome "+user.getFirstName());
				return "home";
			}else {
				redirectAttributes.addFlashAttribute("errMsg", response.getMessage());
				return "redirect:/login";
			}
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("errMsg", "Error Occured. Please Try Again Later");
			return "redirect:/login";
		}
	}

    
//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user, BindingResult bindingResult) {
//    	
//    	if (bindingResult.hasErrors()) {
//    		System.out.println(bindingResult.getAllErrors().toString());
//            return "login";
//        }
//        return "redirect:/home";
//    }
}
