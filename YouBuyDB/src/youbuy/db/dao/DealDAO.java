package youbuy.db.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import youbuy.db.model.Deal;

/**
 * A data access object (DAO) providing persistence and search support for Deal
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see .Deal
 * @author MyEclipse Persistence Tools
 */

public class DealDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DealDAO.class);
	// property constants
	public static final String CITY_ID = "cityId";
	public static final String MERCH_ID = "merchId";
	public static final String DEAL_ORIGIN = "dealOrigin";
	public static final String DEAL_TITLE = "dealTitle";
	public static final String DEAL_RANK = "dealRank";
	public static final String DEAL_URL = "dealUrl";
	public static final String DEAL_IMG = "dealImg";
	public static final String DEAL_CATE = "dealCate";
	public static final String DEAL_SUBCATE = "dealSubcate";
	public static final String DEAL_DESC = "dealDesc";
	public static final String DEAL_VALUE = "dealValue";
	public static final String DEAL_PRICE = "dealPrice";
	public static final String DEAL_REBATE = "dealRebate";
	public static final String DEAL_SALES_MIN = "dealSalesMin";
	public static final String DEAL_SALES_NUM = "dealSalesNum";
	public static final String DEAL_SOLD_OUT = "dealSoldOut";

	public void save(Deal transientInstance) {
		log.debug("saving Deal instance");
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

	public void delete(Deal persistentInstance) {
		log.debug("deleting Deal instance");
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

	public Deal findById(java.lang.Integer id) {
		log.debug("getting Deal instance with id: " + id);
		try {
			Transaction transaction = getSession().beginTransaction();
			Deal instance = (Deal) getSession().get("Deal", id);
			transaction.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Deal> findByExample(Deal instance) {
		log.debug("finding Deal instance by example");
		try {
			Transaction transaction = getSession().beginTransaction();
			List<Deal> results = (List<Deal>) getSession()
					.createCriteria("Deal").add(create(instance)).list();
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
		log.debug("finding Deal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Deal as model where model."
					+ propertyName + "= ?";
			Transaction transaction = getSession().beginTransaction();
			Query queryObject = getSession().createQuery(queryString);
			transaction.commit();
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Deal> findByCityId(Object cityId) {
		return findByProperty(CITY_ID, cityId);
	}

	public List<Deal> findByMerchId(Object merchId) {
		return findByProperty(MERCH_ID, merchId);
	}

	public List<Deal> findByDealOrigin(Object dealOrigin) {
		return findByProperty(DEAL_ORIGIN, dealOrigin);
	}

	public List<Deal> findByDealTitle(Object dealTitle) {
		return findByProperty(DEAL_TITLE, dealTitle);
	}

	public List<Deal> findByDealRank(Object dealRank) {
		return findByProperty(DEAL_RANK, dealRank);
	}

	public List<Deal> findByDealUrl(Object dealUrl) {
		return findByProperty(DEAL_URL, dealUrl);
	}

	public List<Deal> findByDealImg(Object dealImg) {
		return findByProperty(DEAL_IMG, dealImg);
	}

	public List<Deal> findByDealCate(Object dealCate) {
		return findByProperty(DEAL_CATE, dealCate);
	}

	public List<Deal> findByDealSubcate(Object dealSubcate) {
		return findByProperty(DEAL_SUBCATE, dealSubcate);
	}

	public List<Deal> findByDealDesc(Object dealDesc) {
		return findByProperty(DEAL_DESC, dealDesc);
	}

	public List<Deal> findByDealValue(Object dealValue) {
		return findByProperty(DEAL_VALUE, dealValue);
	}

	public List<Deal> findByDealPrice(Object dealPrice) {
		return findByProperty(DEAL_PRICE, dealPrice);
	}

	public List<Deal> findByDealRebate(Object dealRebate) {
		return findByProperty(DEAL_REBATE, dealRebate);
	}

	public List<Deal> findByDealSalesMin(Object dealSalesMin) {
		return findByProperty(DEAL_SALES_MIN, dealSalesMin);
	}

	public List<Deal> findByDealSalesNum(Object dealSalesNum) {
		return findByProperty(DEAL_SALES_NUM, dealSalesNum);
	}

	public List<Deal> findByDealSoldOut(Object dealSoldOut) {
		return findByProperty(DEAL_SOLD_OUT, dealSoldOut);
	}

	public List findAll() {
		log.debug("finding all Deal instances");
		try {
			String queryString = "from Deal";
			Transaction transaction = getSession().beginTransaction();
			Query queryObject = getSession().createQuery(queryString);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Deal merge(Deal detachedInstance) {
		log.debug("merging Deal instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			Deal result = (Deal) getSession().merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Deal instance) {
		log.debug("attaching dirty Deal instance");
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

	public void attachClean(Deal instance) {
		log.debug("attaching clean Deal instance");
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