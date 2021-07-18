package com.stuartkruze.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stuartkruze.models.Employee;
import com.stuartkruze.util.HibernateUtil;

public class EmployeeRepoImpl implements EmployeeRepo {

	@Override
	public Employee addEmployee(Employee em) {

		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			em.setId((int)sess.save(em));
			sess.getTransaction().commit();		
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			em = null;
		} finally {
			sess.close();
		}
		
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
	
		Session sess = HibernateUtil.getSession();
		List<Employee> employees = null;
		try {
			employees = sess.createQuery("FROM Employee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		
		Session sess = HibernateUtil.getSession();
		Employee em = null;

		try {
			em = sess.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return em;
	}


	@Override
	public Employee updateEmployee(Employee change) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return change;
	}

	@Override
	public Employee deleteEmployee(int id) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Employee em = sess.get(Employee.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(em);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return em;
	}

	@Override
	public Employee getEmployeeByName(String fname, String lname) {
		
			Session sess = HibernateUtil.getSession();

			CriteriaBuilder builder = sess.getCriteriaBuilder();
			
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			
			
			Root<Employee> root = query.from(Employee.class);
			query.select(root)
					.where(builder.equal( root.get("first_name"), fname), builder.equal( root.get("last_name"), lname));
								
			//List<Employee> employees = sess.createQuery(query).getResultList();
			
			query.orderBy(builder.asc( root.get("last_name") ));
			
			TypedQuery<Employee> typedQuery = sess.createQuery(query);
			 
			typedQuery.setFirstResult(1);
			 
			typedQuery.setMaxResults(1);

			Employee employee = (Employee) typedQuery.getResultList();
			
			return employee;
	
	}

}
