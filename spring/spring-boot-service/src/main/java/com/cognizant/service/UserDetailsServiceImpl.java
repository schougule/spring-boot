package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.domain.User;

@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<User> getUserDetails(String username) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(User.class);

		SimpleExpression restrictions = Restrictions.eq("username", username);

		criteria.add(restrictions);

		List<User> userList = criteria.list();

		Optional<User> user = Optional.of(userList.get(0));

		return user;

	}

	@Override
	public void creatUser(User user) {
		Session session = sessionFactory.getCurrentSession();

		session.save(user);

	}

}
