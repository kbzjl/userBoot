package cn.ekgc.userBoot.pojo.enums;

import cn.ekgc.userBoot.pojo.vo.ResponseVO;

/**
 * <b>响应编码枚举类型</d>
 * @Author Administrator
 * @Date 2021/12/7 15:40
 * @Version 1.0
 */
public enum ResponseCode {
	RESPONSE_SUCCESS(20000,"系统响应逻辑处理成功"),
	RESPONSE_ERROR(40000,"系统业务逻辑处理错误"),
	RESPONSE_EXCEPTION(50000,"系统响应异常");

	private Integer code;
	private String remark;

	private ResponseCode(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
