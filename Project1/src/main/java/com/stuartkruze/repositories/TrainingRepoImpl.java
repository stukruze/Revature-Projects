package com.stuartkruze.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stuartkruze.models.Training;
import com.stuartkruze.util.HibernateUtil;

public class TrainingRepoImpl implements TrainingRepo {

	@Override
	public Training addTraining(Training t) {

		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			t.setId((int)sess.save(t));
			sess.getTransaction().commit();		
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			t = null;
		} finally {
			sess.close();
		}
		
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Training> getAllTrainings() {
		
		Session sess = HibernateUtil.getSession();
		List<Training> trainings = null;
		try {
			trainings = sess.createQuery("FROM Employee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return trainings;
	}

	@Override
	public Training getTraining(int id) {
		
		Session sess = HibernateUtil.getSession();
		Training t = null;

		try {
			t = sess.get(Training.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return t;
	}

	@Override
	public Training updateTraining(Training change) {
		
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
	public Training deleteTraining(int id) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Training t = sess.get(Training.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(t);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return t;
	}

}
