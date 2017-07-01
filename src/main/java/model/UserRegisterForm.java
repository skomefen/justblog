package model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRegisterForm {
	
	@NotEmpty(message = "没有用户名")
	private String username;
	@NotEmpty(message = "没有密码")
	private String password;
	@NotEmpty(message = "没有昵称")
	private String nickname;
	@NotEmpty(message = "没有邮箱")
	@Email(message = "邮箱格式错误")
	private String email;
	
	@Pattern(regexp="(\\d{11})|(\\s*)",message="号码格式错误")
	private String phone;
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
	
}
