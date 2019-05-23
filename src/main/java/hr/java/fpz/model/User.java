package hr.java.fpz.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;



public class User {
	public User(String username, String password, String email, Integer userType) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}
	public User(){
		super();
	}
	
	@NotNull
	@Size(min=5, max=16)
	private String username;
	@NotNull
	@Size(min=8, max=16)
	private String password;
	@NotNull
	@Pattern(regexp = ".*@[a-z]+\\.[a-z]{2,3}")
	private String email;
	private Integer userType;
	private MultipartFile picture;
	private Integer id;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
