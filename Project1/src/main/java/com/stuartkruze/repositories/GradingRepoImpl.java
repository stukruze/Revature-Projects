package com.stuartkruze.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stuartkruze.models.Grading;
import com.stuartkruze.util.HibernateUtil;

public class GradingRepoImpl implements GradingRepo {

	@Override
	public Grading addGrading(Grading g) {

		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			g.setId((int)sess.save(g));
			sess.getTransaction().commit();		
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			g = null;
		} finally {
			sess.close();
		}
		
		return g;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grading> getAllGradings() {
		
		Session sess = HibernateUtil.getSession();
		List<Grading> gradings = null;
		try {
			gradings = sess.createQuery("FROM Grading").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return gradings;
	}

	@Override
	public Grading getGrading(int id) {
		
		Session sess = HibernateUtil.getSession();
		Grading g = null;

		try {
			g = sess.get(Grading.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return g;
	}

	@Override
	public Grading updateGrading(Grading change) {
		
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
	public Grading deleteGrading(int id) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Grading g = sess.get(Grading.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(g);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return g;
	}

}
