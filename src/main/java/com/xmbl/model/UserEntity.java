package com.xmbl.model;

import com.xmbl.mongo.pojo.GeneralBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserEntity extends GeneralBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String   							name;
	private String   							code;
	private String   							phone;
	private int   								sex;
	private String   							address;
	
	public UserEntity(String name, String code, String phone, int sex, String address) {
		super();
		this.name = name;
		this.code = code;
		this.phone = phone;
		this.sex = sex;
		this.address = address;
	}
	
	

}
