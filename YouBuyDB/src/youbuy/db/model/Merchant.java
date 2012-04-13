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

package youbuy.db.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Merchant entity. @author Mao Yujie
 */
@Entity
@Table(name = "merchant", catalog = "youbuy")
public class Merchant implements java.io.Serializable {

	// Fields

	private Integer merchId;
	private String merchName;
	private String merchAddress;
	private String merchArea;
	private String merchLong;
	private String merchLat;
	private String merchTrafficinfo;
	private String merchTel;
	private String merchEmail;
	private String merchUrl;
	private Set<Deal> deals = new HashSet<Deal>(0);

	// Constructors

	/** default constructor */
	public Merchant() {
	}

	/** minimal constructor */
	public Merchant(Integer merchId) {
		this.merchId = merchId;
	}

	/** full constructor */
	public Merchant(Integer merchId, String merchName, String merchAddress,
			String merchArea, String merchLong, String merchLat,
			String merchTrafficinfo, String merchTel, String merchEmail,
			String merchUrl, Set<Deal> deals) {
		this.merchId = merchId;
		this.merchName = merchName;
		this.merchAddress = merchAddress;
		this.merchArea = merchArea;
		this.merchLong = merchLong;
		this.merchLat = merchLat;
		this.merchTrafficinfo = merchTrafficinfo;
		this.merchTel = merchTel;
		this.merchEmail = merchEmail;
		this.merchUrl = merchUrl;
		this.deals = deals;
	}

	// Property accessors
	@Id
	@Column(name = "merch_id", unique = true, nullable = false)
	public Integer getMerchId() {
		return this.merchId;
	}

	public void setMerchId(Integer merchId) {
		this.merchId = merchId;
	}

	@Column(name = "merch_name", length = 50)
	public String getMerchName() {
		return this.merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	@Column(name = "merch_address", length = 50)
	public String getMerchAddress() {
		return this.merchAddress;
	}

	public void setMerchAddress(String merchAddress) {
		this.merchAddress = merchAddress;
	}

	@Column(name = "merch_area", length = 50)
	public String getMerchArea() {
		return this.merchArea;
	}

	public void setMerchArea(String merchArea) {
		this.merchArea = merchArea;
	}

	@Column(name = "merch_long", length = 50)
	public String getMerchLong() {
		return this.merchLong;
	}

	public void setMerchLong(String merchLong) {
		this.merchLong = merchLong;
	}

	@Column(name = "merch_lat", length = 50)
	public String getMerchLat() {
		return this.merchLat;
	}

	public void setMerchLat(String merchLat) {
		this.merchLat = merchLat;
	}

	@Column(name = "merch_trafficinfo", length = 1024)
	public String getMerchTrafficinfo() {
		return this.merchTrafficinfo;
	}

	public void setMerchTrafficinfo(String merchTrafficinfo) {
		this.merchTrafficinfo = merchTrafficinfo;
	}

	@Column(name = "merch_tel", length = 15)
	public String getMerchTel() {
		return this.merchTel;
	}

	public void setMerchTel(String merchTel) {
		this.merchTel = merchTel;
	}

	@Column(name = "merch_email", length = 100)
	public String getMerchEmail() {
		return this.merchEmail;
	}

	public void setMerchEmail(String merchEmail) {
		this.merchEmail = merchEmail;
	}

	@Column(name = "merch_url", length = 256)
	public String getMerchUrl() {
		return this.merchUrl;
	}

	public void setMerchUrl(String merchUrl) {
		this.merchUrl = merchUrl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Deal> getDeals() {
		return this.deals;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}

}