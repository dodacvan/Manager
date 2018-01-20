package com.validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dao.UserInfoDAO;
import com.entity.User;
@Component
public class UpdateUserValidation {
	@Autowired
	private UserInfoDAO UserInfoDAO;
	
	public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
    	User user = (User)target;
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();
        
        if (password != null && !password.isEmpty()){
        	if(!password.equals(confirmPassword)){
        		errors.rejectValue("password","password.notmatch","Password not match");
        	}
        }else if(confirmPassword != null && !confirmPassword.isEmpty()){
        	errors.rejectValue("password","password.notmatch","Password not match");
        }
    }
}
