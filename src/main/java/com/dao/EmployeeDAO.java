package com.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class EmployeeDAO {
	@Autowired
    private SessionFactory sessionFactory;
 
    public EmployeeDAO() {
 
    }
    
    @SuppressWarnings("unchecked")
    public List<Employee> listEmployee(){
    	Session session = this.sessionFactory.getCurrentSession();
    	 
        List<Employee> list = session.createQuery("from Employee").list();
   
        return list;
    }
    
    public Employee getEmployeeById(int Employee_id){
    	return (Employee) sessionFactory.getCurrentSession().get(Employee.class, Employee_id);
    }
    
    public void saveEmployee(Employee emp){
    	sessionFactory.getCurrentSession().save(emp);
    }
    
    public void updateEmployee(Employee emp){
    	sessionFactory.getCurrentSession().update(emp);
    }
    
    public boolean checkExistUser(String email) {
		String hql="from "+ Employee.class.getName()+" where email = :email";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		return !query.list().isEmpty();
	}
    
    public void deleteEmployee(int Employee_id){
    	Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, Employee_id);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }
    
    public List<Employee> employeeDepart(int id){
    	Session session = this.sessionFactory.getCurrentSession();
   	 
        List<Employee> list = session.createQuery("from Employee emp where emp.department.id=" + id + " ").list();
   
        return list;
    }
}
