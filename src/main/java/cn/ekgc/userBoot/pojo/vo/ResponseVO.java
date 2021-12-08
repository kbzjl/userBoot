package cn.ekgc.userBoot.pojo.vo;

import cn.ekgc.userBoot.pojo.enums.ResponseCode;
import com.mysql.cj.protocol.Message;

import javax.xml.ws.Response;
import java.io.Serializable;

/**
 * <b>响应视图信息</d>
 *
 * @Author Administrator
 * @Date 2021/12/7 15:27
 * @Version 1.0
 */
public class ResponseVO implements Serializable {
	private static final long serialVersionUID = 1664937957200369818L;
	private Integer code;       //响应编码
	private String message;    //响应消息
	private Object data;       //响应数据

	private ResponseVO(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * <b>获得系统响应成功视图信息</b>
	 * @param message
	 * @return
	 */
	public static ResponseVO getSuccess(String message){
		return new ResponseVO(ResponseCode.RESPONSE_SUCCESS.getCode(), message ,"");
	}
	/**
	 * <b>获得系统响应成功视图信息</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO getSuccess(Object data){
		return new ResponseVO(ResponseCode.RESPONSE_SUCCESS.getCode(),ResponseCode.RESPONSE_SUCCESS.getRemark(),data);
	}

	/**
	 * <b>获得系统响应错误视图信息</b>
	 * @param errorMessage
	 * @return
	 */
	public static ResponseVO getError(String errorMessage){
		return new ResponseVO(ResponseCode.RESPONSE_ERROR.getCode(), errorMessage,"");
	}

	/**
	 * <b>获得系统响应异常信息</b>
	 * @param exception
	 * @return
	 */
	public static ResponseVO getException(Exception exception ){
		return new ResponseVO(ResponseCode.RESPONSE_EXCEPTION.getCode(),exception.getMessage(),"");
	}
}
