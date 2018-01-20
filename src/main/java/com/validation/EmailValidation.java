package com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dao.EmployeeDAO;
import com.entity.Employee;
@Component
public class EmailValidation implements Validator {
	@Autowired
	private EmployeeDAO EmployeeDAO;
	
	public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
    	Employee employee = (Employee)target;
        String email = employee.getEmail();
        //Business validation
        if(EmployeeDAO.checkExistUser(email)){
            errors.rejectValue("email","email.unique","Email is exist");
        }
    }
}
