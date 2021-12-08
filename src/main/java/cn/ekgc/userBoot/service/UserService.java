package cn.ekgc.userBoot.service;

import cn.ekgc.userBoot.pojo.vo.UserVO;

/**
 * <b>用户功能业务层接口</b>
 * @Author Miracle Luna
 * @Date 2021/12/7 22:52
 * @Version 1.0
 */
public interface UserService {
	/**
	 * <b>保存用户信息</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	boolean saveUser(UserVO userVO) throws Exception;

	/**
	 * <b>根据手机号查询</b>
	 * @param cellphone
	 * @return
	 */
	UserVO getUserByCellphone(String cellphone)throws Exception;
}
