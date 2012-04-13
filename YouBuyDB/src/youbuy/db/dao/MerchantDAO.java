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

import youbuy.db.model.Merchant;

/**
 * A data access object (DAO) providing persistence and search support for
 * Merchant entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see youbuy.db.dao.Merchant
 * @author Mao Yujie
 */

public class MerchantDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MerchantDAO.class);
	// property constants
	public static final String MERCH_NAME = "merchName";
	public static final String MERCH_ADDRESS = "merchAddress";
	public static final String MERCH_AREA = "merchArea";
	public static final String MERCH_LONG = "merchLong";
	public static final String MERCH_LAT = "merchLat";
	public static final String MERCH_TRAFFICINFO = "merchTrafficinfo";
	public static final String MERCH_TEL = "merchTel";
	public static final String MERCH_EMAIL = "merchEmail";
	public static final String MERCH_URL = "merchUrl";

	public void save(Merchant transientInstance) {
		log.debug("saving Merchant instance");
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

	public void delete(Merchant persistentInstance) {
		log.debug("deleting Merchant instance");
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

	public Merchant findById(java.lang.Integer id) {
		log.debug("getting Merchant instance with id: " + id);
		try {
			Transaction transaction = getSession().beginTransaction();
			Merchant instance = (Merchant) getSession().get(
					"youbuy.db.dao.Merchant", id);
			transaction.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Merchant> findByExample(Merchant instance) {
		log.debug("finding Merchant instance by example");
		try {
			Transaction transaction = getSession().beginTransaction();
			List<Merchant> results = (List<Merchant>) getSession()
					.createCriteria("youbuy.db.dao.Merchant")
					.add(create(instance)).list();
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
		log.debug("finding Merchant instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Merchant as model where model."
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

	public List<Merchant> findByMerchName(Object merchName) {
		return findByProperty(MERCH_NAME, merchName);
	}

	public List<Merchant> findByMerchAddress(Object merchAddress) {
		return findByProperty(MERCH_ADDRESS, merchAddress);
	}

	public List<Merchant> findByMerchArea(Object merchArea) {
		return findByProperty(MERCH_AREA, merchArea);
	}

	public List<Merchant> findByMerchLong(Object merchLong) {
		return findByProperty(MERCH_LONG, merchLong);
	}

	public List<Merchant> findByMerchLat(Object merchLat) {
		return findByProperty(MERCH_LAT, merchLat);
	}

	public List<Merchant> findByMerchTrafficinfo(Object merchTrafficinfo) {
		return findByProperty(MERCH_TRAFFICINFO, merchTrafficinfo);
	}

	public List<Merchant> findByMerchTel(Object merchTel) {
		return findByProperty(MERCH_TEL, merchTel);
	}

	public List<Merchant> findByMerchEmail(Object merchEmail) {
		return findByProperty(MERCH_EMAIL, merchEmail);
	}

	public List<Merchant> findByMerchUrl(Object merchUrl) {
		return findByProperty(MERCH_URL, merchUrl);
	}

	public List findAll() {
		log.debug("finding all Merchant instances");
		try {
			String queryString = "from Merchant";
			Transaction transaction = getSession().beginTransaction();
			Query queryObject = getSession().createQuery(queryString);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Merchant merge(Merchant detachedInstance) {
		log.debug("merging Merchant instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			Merchant result = (Merchant) getSession().merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Merchant instance) {
		log.debug("attaching dirty Merchant instance");
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

	public void attachClean(Merchant instance) {
		log.debug("attaching clean Merchant instance");
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