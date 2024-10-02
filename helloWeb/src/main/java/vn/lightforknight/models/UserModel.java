package vn.lightforknight.models;

import java.io.Serializable;
import java.util.Date; // Ensure Date is imported


public class UserModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6581167777638527522L;
	
	
	private int id;
	private String username;
	private String password;
	private String images;
	private String fullname;
	private String email;
	private String phone;
	private String roleid;
	private Date createDate;
	
	public UserModel(int id, String username, String password, String image, String fullname, String email,
			String phone, String roleid, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.images = images;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getImages() {
		return images;
	}

	public void setImage(String images) {
		this.images = images;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		
		
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", images=" + images
				+ ", fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", roleid=" + roleid + "]";
	}
	
	
		
	
	
}