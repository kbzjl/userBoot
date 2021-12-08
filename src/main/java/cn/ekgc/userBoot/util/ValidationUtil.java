package cn.ekgc.userBoot.util;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Pattern;

/**
 * <b>校验是手机是否正确</b>
 * @Author Miracle Luna
 * @Date 2021/12/7 22:34
 * @Version 1.0
 */
public class ValidationUtil {
	private static final Pattern CELLPHONE_REGEX = Pattern.compile("1[0-9]{10}");
	public static boolean isCellphone(String cellphone){
		if(StrUtil.isNotBlank(cellphone) && CELLPHONE_REGEX.matcher(cellphone).find()){
			return true;
		}
		return false;
	}
}
