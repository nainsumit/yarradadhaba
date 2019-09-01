package com.restaurant.user.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.generic.logger.LogHelper;
import com.restaurant.menu.dao.MenuDao;
import com.restaurant.user.bean.User;

@Repository("userDao")
public class UserDao implements IUserDao
{
	private LogHelper logHelper = LogHelper.getInstance();

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean userLogin(User user)
	{
		logHelper.logData(logHelper.DEBUG, MenuDao.class, "userLogin", "-----------Starts-----------");

		Session session = sessionFactory.getCurrentSession();

		Transaction transaction = session.beginTransaction();

		boolean result = false;

		try
		{
			Criteria c = session.createCriteria(User.class).add(Restrictions.eq("status", "TRUE"))
					.add(Restrictions.eq("email", user.getEmail()))
					.add(Restrictions.eq("password", user.getPassword()));

			c.setProjection(Projections.rowCount());

			result = (Long) c.uniqueResult() > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (transaction != null)
				transaction.commit();

			if (session != null)
				session.close();
		}

		logHelper.logData(logHelper.DEBUG, MenuDao.class, "userLogin", "-----------Ends-----------");

		return result;
	}

	@Override
	public boolean registerUser(User user)
	{
		logHelper.logData(logHelper.DEBUG, MenuDao.class, "registerUser", "-----------Starts-----------");

		Session session = sessionFactory.getCurrentSession();

		Transaction transaction = session.beginTransaction();

		boolean result = false;

		try
		{
			result = session.save(user) != null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (transaction != null)
				transaction.commit();

			if (session != null)
				session.close();
		}

		logHelper.logData(logHelper.DEBUG, MenuDao.class, "registerUser", "-----------Ends-----------");

		return result;
	}

	@Override
	public boolean checkUSerAlreadyExistInDatabase(User user)
	{
		logHelper.logData(logHelper.DEBUG, MenuDao.class, "checkUSerAlreadyExistInDatabase", "-----------Starts-----------");

		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();

		boolean result = false;

		try
		{
			Criteria c = session.createCriteria(User.class).add(Restrictions
					.or(Restrictions.eq("email", user.getEmail()), Restrictions.eq("phone", user.getPhone())));

			c.setProjection(Projections.rowCount());

			result = (Long) c.uniqueResult() > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (transaction != null)
				transaction.commit();

			if (session != null)
				session.close();
		}

		logHelper.logData(logHelper.DEBUG, MenuDao.class, "checkUSerAlreadyExistInDatabase", "-----------Ends-----------");

		return result;
	}

}
