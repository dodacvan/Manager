package com.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entity.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DepartmentDAO {
	@Autowired
    private SessionFactory sessionFactory;
 
    public DepartmentDAO() {
 
    }
    
    @SuppressWarnings("unchecked")
    public List<Department> listDepartment(){
    	Session session = this.sessionFactory.getCurrentSession();
    	 
        List<Department> list = session.createQuery("from Department").list();
   
        return list;
    }
    
    public Department getDepartmentById(int Department_id){
    	return (Department) sessionFactory.getCurrentSession().get(Department.class, Department_id);
    }
    
    public void deleteDepartment(int id){
    	Department depart = (Department) sessionFactory.getCurrentSession().load(
    			Department.class, id);
        if (null != depart) {
            this.sessionFactory.getCurrentSession().delete(depart);
        }
    }
    
    public void saveDepartment(Department depart){
    	sessionFactory.getCurrentSession().save(depart);
    }
    
    public void updateDepartmet(Department depart){
    	sessionFactory.getCurrentSession().update(depart);
    }
}
