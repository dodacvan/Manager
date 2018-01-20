package com.controller;

import java.security.Principal;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dao.DepartmentDAO;
import com.dao.EmployeeDAO;
import com.entity.Department;
import com.entity.Employee;

@Controller
@Transactional
public class DepartmentController {
	@Autowired
	private EmployeeDAO EmployeeDAO;

	@Autowired
	private DepartmentDAO DepartmentDAO;
	
	@RequestMapping(value = "/listDepartment", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		model.addAttribute("listDepart", DepartmentDAO.listDepartment());
		return "listDepartment";
	}

	@RequestMapping(value = "/Departmentinfo", method = RequestMethod.GET)
	public ModelAndView departmentinfo(@RequestParam("id") int department_id) {
		ModelAndView mav = new ModelAndView("departmentInfo");
		Department department = DepartmentDAO.getDepartmentById(department_id);
		mav.addObject("department", department);
		return mav;
	}
	
	@RequestMapping(value = "/deleteDepart", method = RequestMethod.GET)
	public String deleteDepartment(@RequestParam("id") int department_id){
		DepartmentDAO.deleteDepartment(department_id);
		return "redirect:/listDepartment";
	}
	
	@RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
	public String newDepartment(Model model) {
		Department department = new Department();
		List<Employee> listEmployee = EmployeeDAO.listEmployee();
		model.addAttribute("listEmp", listEmployee);
		model.addAttribute("department", department);
		return "addDepartment";
	}
	
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String saveDepartment(@Valid @ModelAttribute("department") Department department, BindingResult result,
			SessionStatus status, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			List<Employee> listEmployee = EmployeeDAO.listEmployee();
			model.addAttribute("listEmp", listEmployee);
            return "addDepartment";
        }
		redirectAttributes.addFlashAttribute("messageSuccess", "add new department success");
		DepartmentDAO.saveDepartment(department);
		return "redirect:/listDepartment";
	}
	
	@RequestMapping(value = "/editDepartment", method = RequestMethod.GET)
	public String editDepartment(@RequestParam("Department_id") int department_id, Model model){
		Department department = DepartmentDAO.getDepartmentById(department_id);
		List<Employee> listEmployee = EmployeeDAO.listEmployee();
		model.addAttribute("listEmp", listEmployee);
		model.addAttribute("department", department);
		return "editDepartment";
	}
	
	@RequestMapping(value = "/editDepartment", method = RequestMethod.POST)
	public String updateDepartment(@Valid @ModelAttribute("department") 
									Department department, 
									BindingResult result, 
									@RequestParam("Department_id") int department_id, 
									Model model, 
									RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			List<Employee> listEmployee = EmployeeDAO.listEmployee();
			model.addAttribute("listEmp", listEmployee);
			return "editDepartment";
		}
		redirectAttributes.addFlashAttribute("messageSuccess", "edit department susscess");
		DepartmentDAO.updateDepartmet(department);
		return "redirect:/listDepartment";
	}
	@RequestMapping(value = "/employeeDepart", method = RequestMethod.GET)
	public String employeeDepart(Model model, @RequestParam("id") int id){
		model.addAttribute("tests", EmployeeDAO.employeeDepart(id));
		return "listEmployee";
	}
}
