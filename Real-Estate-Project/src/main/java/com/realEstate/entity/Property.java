package com.realEstate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipcode")
	private Integer zip;
	
	@Column(name = "date_posted")
	private Integer datePosted;
	
	@Column(name = "house_size")
	private Integer houseSize;
	
	@Column(name = "sale_price")
	private Integer salePrice;
	
	@Column(name = "isListed")
	private Boolean isListed;
	
	public Property(){
		
	}

	public Property(Integer id, String street, String city, String state, Integer zip, Integer datePosted,
			Integer houseSize, Integer salePrice, Boolean isListed) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.datePosted = datePosted;
		this.houseSize = houseSize;
		this.salePrice = salePrice;
		this.isListed = isListed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Integer datePosted) {
		this.datePosted = datePosted;
	}

	public Integer getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(Integer houseSize) {
		this.houseSize = houseSize;
	}

	public Integer getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}

	public Boolean getIsListed() {
		return isListed;
	}

	public void setIsListed(Boolean isListed) {
		this.isListed = isListed;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", datePosted=" + datePosted + ", houseSize=" + houseSize + ", salePrice=" + salePrice + ", isListed="
				+ isListed + "]";
	}
	
}
