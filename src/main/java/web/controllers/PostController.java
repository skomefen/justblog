package web.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import model.PostForm;
import model.PostModel;
import model.UserModel;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.ClientBusiness;
import service.impl.ClientBusinessImpl;
import util.MyWebUtils;

@Controller
@RequestMapping("/post")
@SessionAttributes("user")
public class PostController {

	@RequestMapping(params = "show", method = RequestMethod.GET)
	public ModelAndView showPost(@RequestParam String postId) {
		ClientBusiness cb = new ClientBusinessImpl();
		PostModel post = cb.findPost(postId);
		String path = post.getContextAddress();

		ModelAndView mv = new ModelAndView("client/post/showPost");
		mv.addObject("post", post);
		
		File contextFile = new File(path);
		
		if (!(contextFile.exists() || contextFile.canRead())) {
			return mv;
		}
		FileInputStream in = null;
		ByteArrayOutputStream bos = null;
		try {
			in = new FileInputStream(contextFile);
			byte[] buffer = new byte[1024];
			bos = new ByteArrayOutputStream();			
			int len = 0;
			while((len=in.read(buffer))>0){
				bos.write(buffer, 0, len);
			}
			mv.addObject("context",bos.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				in.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}finally{
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		}

		return mv;
	}

	@RequestMapping(params = "add", method = RequestMethod.GET)
	public String gotoEditPost(ModelMap model, HttpServletRequest request) {
		UserModel user = (UserModel) model.get("user");
		if (user == null) {
			model.addAttribute("message",
					"ÄãÎ´µÇÂ½£¬ÇëµÇÂ¼¡£<meta http-equiv='refresh' content='3;url="
							+ request.getContextPath() + "/login'>");
			return "message";
		}
		return "client/post/addPost";
	}

	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String addPost(@ModelAttribute @Valid PostForm postform,
			BindingResult result, ModelMap model, HttpServletRequest request) {
		UserModel user = (UserModel) model.get("user");
		if (user == null) {
			model.addAttribute("message",
					"ÄãÎ´µÇÂ½£¬ÇëµÇÂ¼¡£<meta http-equiv='refresh' content='3;url="
							+ request.getContextPath() + "/login'>");
			return "message";
		}
		
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			List<String> error = new ArrayList<String>();
			for (FieldError e : errors) {
				error.add(e.getDefaultMessage());
			}
			model.addAttribute("error", error);
			return "client/post/addPost";
		}
		
		postform.setUser_id(user.getId());
		PostModel post = new PostModel();
		BeanUtils.copyProperties(postform, post);
		
		post.setId(MyWebUtils.generateID());
		
		String rootpath = request.getServletContext().getRealPath("/WEB-INF/post/context");
		String path = MyWebUtils.savePostContext(rootpath,post.getTitle(),postform.getContext());
		
		post.setContextAddress(path);
		
		ClientBusiness cb = new ClientBusinessImpl();
		
		cb.addPost(post);
		

		return "redirect:/home";
	}
}
