package cn.ekgc.userBoot.dao;

import cn.ekgc.userBoot.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b></b>
 *
 * @Author Miracle Luna
 * @Date 2021/12/7 23:05
 * @Version 1.0
 */
@Repository
public interface UserDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findUserListByQuery(User query) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param entity
	 * @return
	 */
	int saveUser(User entity)throws Exception;
}
