package store.zys.security.handle;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import store.zys.common.constants.ResultEnum;
import store.zys.common.util.ResponseUtil;
import store.zys.common.util.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Lan
 * @date: 2019/4/9 10:11
 * @description:权限认证异常处理器
 */
public class AuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.write(response, ResultUtil.error(ResultEnum.TOKEN_IS_NOT_VALID));
    }
}
