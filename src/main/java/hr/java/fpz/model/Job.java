package hr.java.fpz.model;

import java.math.BigDecimal;

import org.apache.tomcat.util.codec.binary.Base64;

public class Job {
	private Integer idUser;
	private Integer idJob;
	private String username;
	private String email;
	private String name;
	private String description;
	private BigDecimal price;
	private String picture;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdJob() {
		return idJob;
	}
	public void setIdJob(Integer idJob) {
		this.idJob = idJob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		byte[] encoded = Base64.encodeBase64(picture);
		this.picture = new String(encoded);
	}
	
	
}
