package com.controller;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.UserInfoDAO;
import com.entity.Department;
import com.entity.Employee;
import com.entity.User;
import com.entity.UserRole;
import com.validation.UpdateUserValidation;
 
@Controller
@Transactional
public class UserController {
	@Autowired
	private UserInfoDAO UserInfoDAO;
	
	@Autowired
	UpdateUserValidation UpdateUserValidation;
	
	@RequestMapping(value ="/listUser", method = RequestMethod.GET)
	public String listUser(Model model){
		model.addAttribute("users", UserInfoDAO.getListUser());
		return "listUser";
	}
	
	@RequestMapping(value ="/addUser", method = RequestMethod.GET)
	public String addUser(Model model){
		User user = new User();
		UserRole role = new UserRole();
		List<UserRole> roles = UserInfoDAO.getListRole();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		model.addAttribute("role", role);
		return "addUser";
	}
	
	@RequestMapping(value= "/addUser", method = RequestMethod.POST)
	public String saveUser(
			@Valid @ModelAttribute("user") User user, 
			BindingResult result,
			SessionStatus status, 
			Model model, 
			RedirectAttributes redirectAttributes){
		if (result.hasErrors()) {
			List<UserRole> roles = UserInfoDAO.getListRole();
			model.addAttribute("roles", roles);
            return "addUser";
        }
		redirectAttributes.addFlashAttribute("messageSuccess", "add new employee success");
		UserInfoDAO.saveUser(user, user.getRoles().get(0));
		return "redirect:/listUser";
	}
	
	@RequestMapping(value="editUser", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") String username, 
			Model model, 
			Principal principal, 
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes){
		if(!username.isEmpty() && username.equals(principal.getName())){
			User user = UserInfoDAO.getUserByUsername(username);
			model.addAttribute("user", user);
			return "editUser";
		}
		redirectAttributes.addFlashAttribute("messageSuccess", "you can not edit profile");
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value="editUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("user") User dataUser, 
			BindingResult result,
			Model model, 
			RedirectAttributes redirectAttributes){
		UpdateUserValidation.validate(dataUser, result);
		if (result.hasErrors()) {
			return "editUser";
        }
		redirectAttributes.addFlashAttribute("messageSuccess", "edit information success");
		UserInfoDAO.updateUser(dataUser);
		return "redirect:/listUser";
	}

}
