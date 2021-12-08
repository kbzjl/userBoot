package cn.ekgc.userBoot.service.impl;

import cn.ekgc.userBoot.dao.UserDao;
import cn.ekgc.userBoot.pojo.entity.User;
import cn.ekgc.userBoot.pojo.vo.UserVO;
import cn.ekgc.userBoot.service.UserService;
import cn.ekgc.userBoot.util.PojoMapper;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * <b></b>
 *
 * @Author Miracle Luna
 * @Date 2021/12/7 22:54
 * @Version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private StringRedisTemplate redisTemplate;
	/**
	 * <b>保存用户信息</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean saveUser(UserVO userVO) throws Exception {
		//将需要保存的视图对象转为实体对象
		User user = PojoMapper.INSTANCE.parseEntityFromVO(userVO);
		//进行保存 获得用户主键
		int count = userDao.saveUser(user);
		//通过用户主键 查询保存成功的用户信息
		if (count > 0){
			//创建查询对象
			User query = new User();
			query.setCellphone(userVO.getCellphone());
			//进行列表查询
			List<User> userList = userDao.findUserListByQuery(query);
			if(userList != null && !userList.isEmpty()){
				//将所查询的对象转为视图对象
				UserVO vo = PojoMapper.INSTANCE.parseVOFromEntity(userList.get(0));
				//将视图对象以id作为key 以为对象作为value 存储到Redis中
				//由于Redis 对应的value 是一个String 因此需要将对象转为String
				//由于Json就是一个String 因此可以将该对象先转为Json

				//创建Json对象
				JsonMapper jsonMapper = new JsonMapper();
				//使用JsonMapper将对象转为JSON
				String JSONStr = jsonMapper.writeValueAsString(vo);
				System.out.println(JSONStr);
				//存储到Redis中
				//以用户主键（id）作为key 以用户信息作为value 存储到Redis中
				redisTemplate.opsForValue().set(String.valueOf(vo.getId()),JSONStr);
				//将以用户的手机号码（cellphone）作为key 以用户信息作为value 存储到Redis中
				redisTemplate.opsForValue().set(vo.getCellphone(), JSONStr);
				return true;
			}
		}
		return false;
	}

	/**
	 * <b>根据手机号查询</b>
	 * @param cellphone
	 * @return
	 */
	@Override
	public UserVO getUserByCellphone(String cellphone)throws Exception {
		//首先根据手机号其Redis中进行查询
		String UserVOStr = redisTemplate.opsForValue().get(cellphone);
		if(StrUtil.isNotBlank(UserVOStr)){
			JsonMapper jsonMapper = new JsonMapper();
			UserVO userVO = jsonMapper.readValue(UserVOStr, UserVO.class);
			return userVO;
		}
		//如果没有查询到则去数据库进行查询
		//创建查询对象
		User query = new User();
		query.setCellphone(cellphone);
		List<User> userList = userDao.findUserListByQuery(query);
		if (userList !=null && !userList.isEmpty()){
			return PojoMapper.INSTANCE.parseVOFromEntity(userList.get(0));
		}
		return null;
	}
}
