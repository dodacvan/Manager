package com.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employee;
import com.entity.User;
import com.entity.UserRole;
import com.model.UserInfo;
 
@Repository
@Transactional
public class UserInfoDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public UserInfoDAO() {
 
    }
 
    public UserInfo findUserInfo(String userName) {
        String sql = "Select new " + UserInfo.class.getName() + "(u.username,u.password) "//
                + " from " + User.class.getName() + " u where u.username = :username ";
 
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        query.setParameter("username", userName);
         
        return (UserInfo) query.uniqueResult();
    }
 
    public List<String> getUserRoles(String userName) {
        String sql = "Select r.userRole "//
                + " from " + UserRole.class.getName() + " r where r.user.username = :username ";
 
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        query.setParameter("username", userName);
         
        List<String> roles = query.list();
 
        return roles;
    }
    
    public List<User> getListUser(){
    	Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User").list();  
        return list;
    }
    
    public List<UserRole> getListRole(){
        Session session = sessionFactory.getCurrentSession();
        List<UserRole> list = session.createQuery("from UserRole").list();
        return list;
    }
    
    public void saveUser(User user, UserRole role){
    	sessionFactory.getCurrentSession().save(user);
    	role.setUser(user);
    	sessionFactory.getCurrentSession().save(role);
    }
    
    public User getUserByUsername(String username){
    	Session  session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(User.class);  
        criteria.add(Restrictions.eq("username", username));// (name in entity, param)
        criteria.setProjection(Projections.projectionList()
        	      .add(Projections.property("email"), "email")
        	      .add(Projections.property("username"), "username")) //(name in mysql, name in entity)
        	    .setResultTransformer(Transformers.aliasToBean(User.class));
        List<User> list = criteria.list();
        return list.get(0);
    }
    
    public void updateUser(User user){
    	sessionFactory.getCurrentSession().update(user);
    }
 
}
