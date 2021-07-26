package com.stuartkruze.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stuartkruze.models.Management;
import com.stuartkruze.util.HibernateUtil;

public class ManagementRepoImpl implements ManagementRepo {

	@Override
	public Management addManagement(Management m) {

		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			m.setId((int)sess.save(m));
			sess.getTransaction().commit();		
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			m = null;
		} finally {
			sess.close();
		}
		
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Management> getAllManagements() {
		
		Session sess = HibernateUtil.getSession();
		List<Management> managements = null;
		try {
			managements = sess.createQuery("FROM Management").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return managements;
	}

	@Override
	public Management getManagement(int id) {
		
		Session sess = HibernateUtil.getSession();
		Management m = null;

		try {
			m = sess.get(Management.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return m;
	}

	@Override
	public Management getManagementByName(String fname, String lname) {
		
		Session sess = HibernateUtil.getSession();

		CriteriaBuilder builder = sess.getCriteriaBuilder();
		
		CriteriaQuery<Management> query = builder.createQuery(Management.class);
		
		
		Root<Management> root = query.from(Management.class);
		query.select(root)
				.where(builder.equal( root.get("first_name"), fname), builder.equal( root.get("last_name"), lname));
							
		//List<Employee> employees = sess.createQuery(query).getResultList();
		
		query.orderBy(builder.asc( root.get("last_name") ));
		
		TypedQuery<Management> typedQuery = sess.createQuery(query);
		 
		typedQuery.setFirstResult(1);
		 
		typedQuery.setMaxResults(1);

		Management managment = (Management) typedQuery.getResultList();
		
		return managment;
	}

	@Override
	public Management updateManagement(Management change) {
		
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
	public Management deleteManagement(int id) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Management m = sess.get(Management.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(m);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return m;
	}

}
