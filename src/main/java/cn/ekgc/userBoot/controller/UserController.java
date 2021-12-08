package cn.ekgc.userBoot.controller;

import cn.ekgc.userBoot.pojo.vo.ResponseVO;
import cn.ekgc.userBoot.pojo.vo.UserVO;
import cn.ekgc.userBoot.service.UserService;
import cn.ekgc.userBoot.util.ValidationUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>用户信息控制层</b>
 *
 * @Author Miracle Luna
 * @Date 2021/12/7 22:24
 * @Version 1.0
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Resource(name = "userService")
	private UserService userService;
	@PostMapping("/save")
	public ResponseVO saveUser(@RequestBody UserVO userVO) throws Exception{
		//效验用户所填写的添加信息有效
		if(StrUtil.isNotBlank(userVO.getName())&& ValidationUtil.isCellphone(userVO.getCellphone())){
			//通过先查询 效验手机的唯一性
			UserVO cellphoneUserVO = userService.getUserByCellphone(userVO.getCellphone());
			if(cellphoneUserVO != null ){
				//此时手机已被注册
				return ResponseVO.getError("改手机号已被注册");

			}
			boolean isSuccess = userService.saveUser(userVO);
			//如果是true 保存成功
			if(isSuccess){
				return ResponseVO.getSuccess("添加成功");
			}
			return ResponseVO.getError("保存失败");
		}
		return ResponseVO.getError("未填写有效的添加信息");
	}
}
