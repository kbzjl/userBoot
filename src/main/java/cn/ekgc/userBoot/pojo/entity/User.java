package cn.ekgc.userBoot.pojo.entity;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <b></d>
 *
 * @Author Administrator
 * @Date 2021/12/7 14:55
 * @Version 1.0
 */

public class User implements Serializable {

	private static final long serialVersionUID = 4235822782208513364L;
	private Long id;
	private String name;
	private String cellphone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}
