package com.stuartkruze.repositories;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.stuartkruze.models.Event;
import com.stuartkruze.util.HibernateUtil;

public class EventRepoImpl implements EventRepo {

	@Override
	public Event addEvent(Event ev) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			ev.setId((int) sess.save(ev));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			ev = null;
		} finally {
			sess.close();
		}

		return ev;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getAllEvents() {
		
		Session sess = HibernateUtil.getSession();
		List<Event> events = null;
		try {
			events = sess.createQuery("FROM Event").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return events;
	}

	@Override
	public Event getEvent(int id) {
		
		Session sess = HibernateUtil.getSession();
		Event ev = null;

		try {
			ev = sess.get(Event.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return ev;
	}

	@Override
	public List<Event> getEventByType(String type) {

		
		Session sess = HibernateUtil.getSession();

		CriteriaBuilder builder = sess.getCriteriaBuilder();
		
		CriteriaQuery<Event> query = builder.createQuery(Event.class);
		
		
		Root<Event> root = query.from(Event.class);
		query.select(root)
				.where(builder.equal( root.get("type"), type));
							
		List<Event> events = sess.createQuery(query).getResultList();
		
		
		return events;
	}

	@Override
	public Event updateEvent(Event change) {
		
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
	public Event deleteEvent(int id) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Event ev = sess.get(Event.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(ev);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return ev;
	}

}
