package model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRegisterForm {
	
	@NotEmpty(message = "û���û���")
	private String username;
	@NotEmpty(message = "û������")
	private String password;
	@NotEmpty(message = "û���ǳ�")
	private String nickname;
	@NotEmpty(message = "û������")
	@Email(message = "�����ʽ����")
	private String email;
	
	@Pattern(regexp="(\\d{11})|(\\s*)",message="�����ʽ����")
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
