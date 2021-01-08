package net.javaguides.springmvc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Admin;
@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	//uses Amin class for login (records in admin table is used as credentials(ie username and passsword)
			@Override
			@Transactional
			public List<Admin> getAuthorizedCustomers() {
				Session session = sessionFactory.getCurrentSession();
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<Admin> cq = cb.createQuery(Admin.class);
				Root<Admin> root = cq.from(Admin.class);
				cq.select(root);
				Query query = session.createQuery(cq);
				return query.getResultList();
			}
}
