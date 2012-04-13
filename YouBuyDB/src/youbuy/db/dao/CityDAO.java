/*
 * Copyright (C) 2012 Mao Yujie (maojie0924@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY APPLE COMPUTER, INC. ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL APPLE COMPUTER, INC. OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package youbuy.db.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import youbuy.db.model.City;

/**
 * A data access object (DAO) providing persistence and search support for City
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see youbuy.db.dao.City
 * @author Mao Yujie
 */

public class CityDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CityDAO.class);
	// property constants
	public static final String CITY_NAME = "cityName";
	public static final String CITY_TIMEZONE = "cityTimezone";
	public static final String CITY_LONG = "cityLong";
	public static final String CITY_LAT = "cityLat";
	public static final String CITY_WEBSITE = "cityWebsite";

	public void save(City transientInstance) {
		log.debug("saving City instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(City persistentInstance) {
		log.debug("deleting City instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public City findById(java.lang.Integer id) {
		log.debug("getting City instance with id: " + id);
		try {
			Transaction transaction = getSession().beginTransaction();
			City instance = (City) getSession().get("youbuy.db.dao.City", id);
			transaction.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<City> findByExample(City instance) {
		log.debug("finding City instance by example");
		try {
			Transaction transaction = getSession().beginTransaction();
			List<City> results = (List<City>) getSession()
					.createCriteria("youbuy.db.dao.City").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			transaction.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding City instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from City as model where model."
					+ propertyName + "= ?";
			Transaction transaction = getSession().beginTransaction();
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<City> findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List<City> findByCityTimezone(Object cityTimezone) {
		return findByProperty(CITY_TIMEZONE, cityTimezone);
	}

	public List<City> findByCityLong(Object cityLong) {
		return findByProperty(CITY_LONG, cityLong);
	}

	public List<City> findByCityLat(Object cityLat) {
		return findByProperty(CITY_LAT, cityLat);
	}

	public List<City> findByCityWebsite(Object cityWebsite) {
		return findByProperty(CITY_WEBSITE, cityWebsite);
	}

	public List findAll() {
		log.debug("finding all City instances");
		try {
			String queryString = "from City";
			Transaction transaction = getSession().beginTransaction();
			Query queryObject = getSession().createQuery(queryString);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public City merge(City detachedInstance) {
		log.debug("merging City instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			City result = (City) getSession().merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(City instance) {
		log.debug("attaching dirty City instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().saveOrUpdate(instance);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(City instance) {
		log.debug("attaching clean City instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().lock(instance, LockMode.NONE);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}