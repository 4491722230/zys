package store.zys.security.filter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import store.zys.common.util.*;
import store.zys.dto.UserDTO;
import store.zys.entity.User;
import store.zys.form.LoginForm;
import store.zys.mapper.UserForLoginMapper;
import store.zys.security.handle.JwtTokenUtil;
import store.zys.vo.LoginSuccessVO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//import com.lan.demo.dto.UserDTO;

/**
 * @author: Lan
 * @date: 2019/4/8 15:27
 * @description:处理登录请求
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserForLoginMapper userMapperForLogin;

    private AuthenticationManager authenticationManager;

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 请求登录
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
//            LoginForm loginForm = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
//            checkLoginForm(loginForm, response);
//            LoginUser loginUser = new LoginUser();
//            BeanUtils.copyProperties(loginForm, loginUser);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password, new ArrayList<>()));
//        } catch (IOException e) {
//            ResponseUtil.write(response, ResultUtil.error("数据读取错误"));
//
//        }
        //return null;
    }

    /**
     * 登录成功后
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDTO userDTO = (UserDTO) authResult.getPrincipal();
        if (jwtTokenUtil == null) {
            jwtTokenUtil = (JwtTokenUtil) SpringUtils.getBean("jwtTokenUtil");
        }
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserLastLoginTime(TimeUtil.nowTimeStamp());

        if (userMapperForLogin == null) {
            userMapperForLogin = (UserForLoginMapper) SpringUtils.getBean("userMapper");
        }
        //更新登最近一次录时间
        userMapperForLogin.updateById(user);
        String token = jwtTokenUtil.createToken(userDTO);
        //将token放置请求头返回

        response.addHeader(jwtTokenUtil.getTokenHeader(), jwtTokenUtil.getTokenPrefix() + token);
        LoginSuccessVO loginSuccessVO = new LoginSuccessVO();
        BeanUtils.copyProperties(userDTO, loginSuccessVO);
        ResponseUtil.write(response, ResultUtil.success(loginSuccessVO));
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ResponseUtil.write(response, ResultUtil.error(failed.getMessage()));
    }

    /**
     * 校验参数
     *
     * @param loginForm
     */
    private void checkLoginForm(LoginForm loginForm, HttpServletResponse response) {
        if (BlankUtil.isBlank(loginForm.getUsename())) {
            ResponseUtil.write(response, ResultUtil.error("账号不能为空"));
            return;
        }
        if (BlankUtil.isBlank(loginForm.getUserPassword())) {
            ResponseUtil.write(response, ResultUtil.error("密码不能为空"));
            return;
        }
    }
}
