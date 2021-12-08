package cn.ekgc.userBoot.pojo.vo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <b></d>
 *
 * @Author Administrator
 * @Date 2021/12/7 14:56
 * @Version 1.0
 */
@Repository
public class UserVO implements Serializable {
	private static final long serialVersionUID = 591855250784389205L;
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
