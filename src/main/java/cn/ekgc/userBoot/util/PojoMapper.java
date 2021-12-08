package cn.ekgc.userBoot.util;

import cn.ekgc.userBoot.pojo.entity.User;
import cn.ekgc.userBoot.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * <b>视图实体转换工具类</d>
 *
 * @Author Administrator
 * @Date 2021/12/7 15:07
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface PojoMapper {
	//实例化具体的接口对象
	PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);
	/**
	 * <b>将视图对象转换为实体对象</b>
	 * @param vo
	 * @return
	 */
	User parseEntityFromVO(UserVO vo);

	/**
	 * <b>将实体对象转换为视图对象</b>
	 * @param entity
	 * @return
	 */
	UserVO parseVOFromEntity(User entity);
}
