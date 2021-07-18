package com.stuartkruze.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="address1", nullable = false)
	private String address1;
	@Column(name="address2")
	private String address2;
	@Column(name="city", nullable = false)
	private String city;
	@Column(name="state", nullable = false)
	private String state;
	@Column(name="zip", nullable = false)
	private String zip;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	

	@OneToOne
	@JoinColumn(name="managment_id")
	private Management managmentId;


	public Contact() {
		super();
	}


	public Contact(int id, String address1, String address2, String city, String state, String zip, String email,
			String phone, Management managmentId) {
		super();
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
		this.managmentId = managmentId;
	}


	public Contact(String address1, String address2, String city, String state, String zip, String email, String phone,
			Management managmentId) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
		this.managmentId = managmentId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
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


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Management getManagmentId() {
		return managmentId;
	}


	public void setManagmentId(Management managmentId) {
		this.managmentId = managmentId;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", email=" + email + ", phone=" + phone + ", managmentId=" + managmentId
				+ "]";
	}
	

	
}
