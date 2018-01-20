package com.controller;

import java.security.Principal;
import java.util.List;
import com.dao.EmployeeDAO;
import com.dao.DepartmentDAO;
import com.entity.Employee;
import com.entity.Department;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.validation.EmailValidation;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	private EmployeeDAO EmployeeDAO;

	@Autowired
	private DepartmentDAO DepartmentDAO;
	
	@Autowired
	EmailValidation EmailValidation;

	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		model.addAttribute("tests", EmployeeDAO.listEmployee());
		return "listEmployee";
	}

	@RequestMapping(value = "/employeeinfo", method = RequestMethod.GET)
	public ModelAndView employeeinfo(@RequestParam("Employee_id") int employee_id) {
		ModelAndView mav = new ModelAndView("employeeInfo");
		Employee employee = EmployeeDAO.getEmployeeById(employee_id);
		mav.addObject("employee", employee);
		return mav;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String newEmployee(Model model) {
		Employee employee = new Employee();
		List<Department> listDepartment = DepartmentDAO.listDepartment();
		model.addAttribute("listDepart", listDepartment);
		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			SessionStatus status, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			List<Department> listDepartment = DepartmentDAO.listDepartment();
			model.addAttribute("listDepart", listDepartment);
            return "addEmployee";
        }
		redirectAttributes.addFlashAttribute("messageSuccess", "add new employee success");
		EmployeeDAO.saveEmployee(employee);
		return "redirect:/listEmployee";
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public String editEmployee(@RequestParam("Employee_id") int employee_id, Model model) {
		Employee employee = EmployeeDAO.getEmployeeById(employee_id);
		List<Department> listDepartment = DepartmentDAO.listDepartment();
		model.addAttribute("listDepart", listDepartment);
		model.addAttribute("employee", employee);
		return "editEmployee";
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String updateEmployee(@Valid @ModelAttribute("employee") Employee dataEmployee, BindingResult result,
			@RequestParam("Employee_id") int employee_id, Model model, RedirectAttributes redirectAttributes) {
		EmailValidation.validate(dataEmployee, result);
		if (result.hasErrors()) {
			List<Department> listDepartment = DepartmentDAO.listDepartment();
			model.addAttribute("listDepart", listDepartment);
            return "editEmployee";
        }
		redirectAttributes.addFlashAttribute("messageSuccess", "edit new employee success");
		EmployeeDAO.updateEmployee(dataEmployee);
		return "redirect:/listEmployee";
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		EmployeeDAO.deleteEmployee(employeeId);
		redirectAttributes.addFlashAttribute("messageSuccess", "delete employee success");
		return "redirect:/listEmployee";
	}
}
