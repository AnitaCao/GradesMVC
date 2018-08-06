package com.mvc.dao;
 
import java.io.Serializable;
 
import java.lang.reflect.ParameterizedType;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
/**
 * This Generic class is the base class for all DAO implementation classes. 
 * It provides the wrapper methods for common hibernate operations.
 * @author tingcao
 *
 * @param <PK>
 * @param <T>
 */
public abstract class AbstractDAO<PK extends Serializable, T> {
	  
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDAO(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
    	this.sessionFactory = sf;
    }
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
    public void update(T entity){
    	getSession().update(entity);
    }
 
}