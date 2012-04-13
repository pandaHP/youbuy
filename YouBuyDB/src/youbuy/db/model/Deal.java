package youbuy.db.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Deal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "deal", catalog = "youbuy")
public class Deal implements java.io.Serializable {

	// Fields

	private Integer dealId;
	private City city;
	private Merchant merchant;
	private Integer cityId;
	private Integer merchId;
	private String dealOrigin;
	private String dealTitle;
	private Integer dealRank;
	private String dealUrl;
	private String dealImg;
	private String dealCate;
	private String dealSubcate;
	private String dealDesc;
	private String dealValue;
	private String dealPrice;
	private String dealRebate;
	private Integer dealSalesMin;
	private Integer dealSalesNum;
	private Boolean dealSoldOut;
	private Timestamp dealStartTime;
	private Timestamp dealEndTime;

	// Constructors

	/** default constructor */
	public Deal() {
	}

	/** minimal constructor */
	public Deal(Integer dealId, City city, Merchant merchant, Integer cityId,
			Integer merchId) {
		this.dealId = dealId;
		this.city = city;
		this.merchant = merchant;
		this.cityId = cityId;
		this.merchId = merchId;
	}

	/** full constructor */
	public Deal(Integer dealId, City city, Merchant merchant, Integer cityId,
			Integer merchId, String dealOrigin, String dealTitle,
			Integer dealRank, String dealUrl, String dealImg, String dealCate,
			String dealSubcate, String dealDesc, String dealValue,
			String dealPrice, String dealRebate, Integer dealSalesMin,
			Integer dealSalesNum, Boolean dealSoldOut, Timestamp dealStartTime,
			Timestamp dealEndTime) {
		this.dealId = dealId;
		this.city = city;
		this.merchant = merchant;
		this.cityId = cityId;
		this.merchId = merchId;
		this.dealOrigin = dealOrigin;
		this.dealTitle = dealTitle;
		this.dealRank = dealRank;
		this.dealUrl = dealUrl;
		this.dealImg = dealImg;
		this.dealCate = dealCate;
		this.dealSubcate = dealSubcate;
		this.dealDesc = dealDesc;
		this.dealValue = dealValue;
		this.dealPrice = dealPrice;
		this.dealRebate = dealRebate;
		this.dealSalesMin = dealSalesMin;
		this.dealSalesNum = dealSalesNum;
		this.dealSoldOut = dealSoldOut;
		this.dealStartTime = dealStartTime;
		this.dealEndTime = dealEndTime;
	}

	// Property accessors
	@Id
	@Column(name = "deal_id", unique = true, nullable = false)
	public Integer getDealId() {
		return this.dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deal_id", unique = true, nullable = false, insertable = false, updatable = false)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deal_id", unique = true, nullable = false, insertable = false, updatable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Column(name = "city_id", nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "merch_id", nullable = false)
	public Integer getMerchId() {
		return this.merchId;
	}

	public void setMerchId(Integer merchId) {
		this.merchId = merchId;
	}

	@Column(name = "deal_origin", length = 30)
	public String getDealOrigin() {
		return this.dealOrigin;
	}

	public void setDealOrigin(String dealOrigin) {
		this.dealOrigin = dealOrigin;
	}

	@Column(name = "deal_title", length = 256)
	public String getDealTitle() {
		return this.dealTitle;
	}

	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}

	@Column(name = "deal_rank")
	public Integer getDealRank() {
		return this.dealRank;
	}

	public void setDealRank(Integer dealRank) {
		this.dealRank = dealRank;
	}

	@Column(name = "deal_url", length = 256)
	public String getDealUrl() {
		return this.dealUrl;
	}

	public void setDealUrl(String dealUrl) {
		this.dealUrl = dealUrl;
	}

	@Column(name = "deal_img", length = 300)
	public String getDealImg() {
		return this.dealImg;
	}

	public void setDealImg(String dealImg) {
		this.dealImg = dealImg;
	}

	@Column(name = "deal_cate", length = 30)
	public String getDealCate() {
		return this.dealCate;
	}

	public void setDealCate(String dealCate) {
		this.dealCate = dealCate;
	}

	@Column(name = "deal_subcate", length = 30)
	public String getDealSubcate() {
		return this.dealSubcate;
	}

	public void setDealSubcate(String dealSubcate) {
		this.dealSubcate = dealSubcate;
	}

	@Column(name = "deal_desc", length = 1024)
	public String getDealDesc() {
		return this.dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	@Column(name = "deal_value", length = 60)
	public String getDealValue() {
		return this.dealValue;
	}

	public void setDealValue(String dealValue) {
		this.dealValue = dealValue;
	}

	@Column(name = "deal_price", length = 60)
	public String getDealPrice() {
		return this.dealPrice;
	}

	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}

	@Column(name = "deal_rebate", length = 60)
	public String getDealRebate() {
		return this.dealRebate;
	}

	public void setDealRebate(String dealRebate) {
		this.dealRebate = dealRebate;
	}

	@Column(name = "deal_sales_min")
	public Integer getDealSalesMin() {
		return this.dealSalesMin;
	}

	public void setDealSalesMin(Integer dealSalesMin) {
		this.dealSalesMin = dealSalesMin;
	}

	@Column(name = "deal_sales_num")
	public Integer getDealSalesNum() {
		return this.dealSalesNum;
	}

	public void setDealSalesNum(Integer dealSalesNum) {
		this.dealSalesNum = dealSalesNum;
	}

	@Column(name = "deal_sold_out")
	public Boolean getDealSoldOut() {
		return this.dealSoldOut;
	}

	public void setDealSoldOut(Boolean dealSoldOut) {
		this.dealSoldOut = dealSoldOut;
	}

	@Column(name = "deal_start_time", length = 19)
	public Timestamp getDealStartTime() {
		return this.dealStartTime;
	}

	public void setDealStartTime(Timestamp dealStartTime) {
		this.dealStartTime = dealStartTime;
	}

	@Column(name = "deal_end_time", length = 19)
	public Timestamp getDealEndTime() {
		return this.dealEndTime;
	}

	public void setDealEndTime(Timestamp dealEndTime) {
		this.dealEndTime = dealEndTime;
	}

}