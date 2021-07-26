package com.stuartkruze.repositories;

import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;

import com.stuartkruze.models.Contact;
import com.stuartkruze.util.HibernateUtil;

public class ContactRepoImpl implements ContactRepo {

	@Override
	public Contact addContact(Contact c) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			c.setId((int) sess.save(c));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			c = null;
		} finally {
			sess.close();
		}

		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {

		Session sess = HibernateUtil.getSession();
		List<Contact> contacts = null;
		try {
			contacts = sess.createQuery("FROM Contact").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return contacts;
	}

	@Override
	public Contact getContact(int id) {

		Session sess = HibernateUtil.getSession();
		Contact c = null;

		try {
			c = sess.get(Contact.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return c;
	}

	@Override
	public Contact updateContact(Contact change) {

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
	public Contact deleteContact(int id) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Contact c = sess.get(Contact.class, id);

		try {
			tx = sess.beginTransaction();
			sess.delete(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return c;
	}

	@Override
	public Contact getContactByEmail(String email) {

		Session sess = HibernateUtil.getSession();
		
		Contact c = null;
		Criteria crit = null;
		try {

			crit = sess.createCriteria(Contact.class);

			crit.add(Restrictions.eq("email", email));

//				a = (Actor) crit.uniqueResult();			
			if (crit.list().size() > 0)
				c = (Contact) crit.list().get(0);
//				CriteriaQuery<Actor> crit = sess.getCriteriaBuilder().createQuery(Actor.class);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return c;
	}
}
