package web.controllers;



import model.UserModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ClientBusiness;
import service.impl.ClientBusinessImpl;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "client/user/login";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signin(RedirectAttributes redirectAttrs,@ModelAttribute("username")String username,@ModelAttribute("password")String password,ModelMap model){
		ClientBusiness cb = new ClientBusinessImpl();
		try{
			if(username==null||password==null){
				return "client/user/login";
			}
			UserModel user=cb.login(username, password);
			
			if(user==null){
				model.addAttribute("message", "用户名或密码错误");
				return "client/user/login";
			}
			model.addAttribute("user", user);
		}catch(Exception e){
			model.addAttribute("message", "服务器未知错误");
			return "message";
		}
		return "redirect:/home";
	}
	
	@RequestMapping("signout")
	public String signout(@ModelAttribute(value = "user")UserModel user,SessionStatus status ){
		status.setComplete();
		return "redirect:/home";
	}
	
	
	@RequestMapping(value="/{account}", method=RequestMethod.GET)
	public String show(@PathVariable String account){
		
		return "redirect:/home";
	}
	
}
