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
 * City entity. @author Mao Yujie
 */
@Entity
@Table(name = "city", catalog = "youbuy")
public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private String cityTimezone;
	private String cityLong;
	private String cityLat;
	private String cityWebsite;
	private Set<Deal> deals = new HashSet<Deal>(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Integer cityId) {
		this.cityId = cityId;
	}

	/** full constructor */
	public City(Integer cityId, String cityName, String cityTimezone,
			String cityLong, String cityLat, String cityWebsite, Set<Deal> deals) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityTimezone = cityTimezone;
		this.cityLong = cityLong;
		this.cityLat = cityLat;
		this.cityWebsite = cityWebsite;
		this.deals = deals;
	}

	// Property accessors
	@Id
	@Column(name = "city_id", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "city_name", length = 50)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "city_timezone", length = 50)
	public String getCityTimezone() {
		return this.cityTimezone;
	}

	public void setCityTimezone(String cityTimezone) {
		this.cityTimezone = cityTimezone;
	}

	@Column(name = "city_long", length = 50)
	public String getCityLong() {
		return this.cityLong;
	}

	public void setCityLong(String cityLong) {
		this.cityLong = cityLong;
	}

	@Column(name = "city_lat", length = 50)
	public String getCityLat() {
		return this.cityLat;
	}

	public void setCityLat(String cityLat) {
		this.cityLat = cityLat;
	}

	@Column(name = "city_website", length = 50)
	public String getCityWebsite() {
		return this.cityWebsite;
	}

	public void setCityWebsite(String cityWebsite) {
		this.cityWebsite = cityWebsite;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Deal> getDeals() {
		return this.deals;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}

}