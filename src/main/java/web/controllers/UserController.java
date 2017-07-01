package web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import model.UserModel;
import model.UserRegisterForm;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ClientBusiness;
import util.MyWebUtils;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	ClientBusiness clientbusiness;
	
	@RequestMapping(params="register",method=RequestMethod.GET)
	public String gotoRegisterUI(){
		return "client/user/register";
	}
	
	@RequestMapping(params="register",method=RequestMethod.POST)
	public String register(@ModelAttribute @Valid UserRegisterForm form,BindingResult result,ModelMap model){
		
		if(result.hasErrors()){
			List<FieldError> fieldErrors = result.getFieldErrors();
			Map<String,String> error = new HashMap<String, String>();
			for(FieldError e:fieldErrors){
				error.put(e.getField(), e.getDefaultMessage());
			}
			model.addAttribute("error", error);
			return  "client/user/register";
		}
		
		UserModel user = new UserModel();
		user.setId(MyWebUtils.generateID());
		BeanUtils.copyProperties(form, user);
		
		clientbusiness.addUser(user);
		
		return "redirect:/login";
	}
}
