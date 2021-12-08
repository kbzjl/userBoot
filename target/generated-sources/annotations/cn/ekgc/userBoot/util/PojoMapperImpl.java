package cn.ekgc.userBoot.util;

import cn.ekgc.userBoot.pojo.entity.User;
import cn.ekgc.userBoot.pojo.vo.UserVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T10:36:46+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
@Component
public class PojoMapperImpl implements PojoMapper {

    @Override
    public User parseEntityFromVO(UserVO vo) {
        if ( vo == null ) {
            return null;
        }

        User user = new User();

        user.setId( vo.getId() );
        user.setName( vo.getName() );
        user.setCellphone( vo.getCellphone() );

        return user;
    }

    @Override
    public UserVO parseVOFromEntity(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( entity.getId() );
        userVO.setName( entity.getName() );
        userVO.setCellphone( entity.getCellphone() );

        return userVO;
    }
}
