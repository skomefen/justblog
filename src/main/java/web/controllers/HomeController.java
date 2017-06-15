package web.controllers;

import java.util.List;

import model.PostModel;
import model.QueryInfo;
import model.QueryResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ClientBusiness;
import service.impl.ClientBusinessImpl;

@Controller
public class HomeController {

	
	public ModelAndView addPost(){
		
		return null;
		
	} 
	
	@ModelAttribute("queryResult")
	public QueryResult listPostTitle(@RequestParam(defaultValue="1") int current, @RequestParam(defaultValue="15") int pageSize ){
		ClientBusiness cb = new ClientBusinessImpl();
		if(current<=0||pageSize<=0)
			return null;
		QueryInfo info = new QueryInfo(current,pageSize);
		QueryResult qr = cb.listPost(info);
		
		return qr;
	}
	
	@RequestMapping("/home")
	public String homeListPostTitle(){

		return "home";
	}
	
	@RequestMapping("/")
	public String homeDefaultListPostTitle(){

		return "home";
	}
}
