package com.EcommerceBackendAPI.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
@PrimaryKeyJoinColumn(name = "userid")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	@Column(name = "name", nullable = false, length = 100)
	@Schema(example = "JohnWick")
	private String name;

	@Column(name = "email", nullable = false, length = 100)
	@Schema(example = "JohnWick@gmail.com")
	private String email;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "phoneno", nullable = false, length = 100)
	@Schema(example = "123-456-7890")
	private String phoneno;

	@Column(name = "city", nullable = false, length = 100)
	@Schema(example = "Springfield")
	private String city;

	@Column(name = "district", nullable = false, length = 100)
	@Schema(example = "Springfield District")
	private String district;

	@Column(name = "subDistrict", nullable = false, length = 100)
	@Schema(example = "Downtown")
	private String subDistrict;

	@Column(name = "postalCode", nullable = false)
	@Schema(example = "12345")
	private int postalCode;

	// Getter Setter Methods
	public int getUserid() {
		return userid;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

}
