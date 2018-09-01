package com.fym.hos.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

/**
 * 质控人员类
 * 
 * @author fp
 * @since 2018-08-25
 */
@Entity
@Table(name = "t_user")
@NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t")
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid") // 这个是hibernate的注解/生成32位UUID
	@GeneratedValue(generator = "idGenerator")
	private String id;
	/**
	 * 名称
	 */
	@Column(name = "the_name")
	private String theName;
	
	@Column(name = "the_account")
	private String account;
	
	@Column(name = "the_password")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}