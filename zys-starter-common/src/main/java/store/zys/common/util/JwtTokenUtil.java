//package store.zys.common.util;
//
//
//import com.alibaba.fastjson.JSON;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//import store.zys.dto.UserDTO;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
////import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
//
////import com.lan.demo.dto.UserDTO;
//
///**
// * @author: Lan
// * @date: 2019/4/8 14:19
// * @description:
// */
//@Component
//@ConfigurationProperties(prefix = "jwt")
//
//public class JwtTokenUtil {
//
//    /**
//     * header名称
//     */
//    private String tokenHeader;
//
//    /**
//     * token前缀
//     */
//    private String tokenPrefix;
//
//    /**
//     * 秘钥
//     */
//    private String secret;
//
//    /**
//     * 过期时间
//     */
//    private Long expiration;
//
//    /**
//     * 选择记住后过期时间
//     */
//    private Long rememberExpiration;
//
//    /**
//     * 生成token
//     *
//     * @param userDTO
//     * @return
//     */
//    public String createToken(UserDTO userDTO) {
//        Long time = userDTO.getRemember() ? this.rememberExpiration : this.expiration;
//        Map<String, Object> map = new HashMap<>(1);
//        map.put("user", userDTO);
//        return Jwts.builder()
//                .setClaims(map)
//                .setSubject(userDTO.getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + time * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    /**
//     * 获取用户名
//     *
//     * @param token
//     * @return
//     */
//    public String getUserName(String token) {
//        return generateToken(token).getSubject();
//    }
//
//    /**
//     * 解析token
//     *
//     * @param token
//     * @return
//     */
//    public Claims generateToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    /**
//     * 获取userDTO
//     *
//     * @param token
//     * @return
//     */
//    public UserDTO getUserDTO(String token) {
//        Claims claims = generateToken(token);
//        Map<String, String> map = claims.get("user", Map.class);
//        UserDTO userDTO = JSON.parseObject(JSON.toJSONString(map), UserDTO.class);
//        return userDTO;
//    }
//
//    public String getTokenHeader() {
//        return tokenHeader;
//    }
//
//    public void setTokenHeader(String tokenHeader) {
//        this.tokenHeader = tokenHeader;
//    }
//
//    public String getTokenPrefix() {
//        return tokenPrefix;
//    }
//
//    public void setTokenPrefix(String tokenPrefix) {
//        this.tokenPrefix = tokenPrefix;
//    }
//
//    public String getSecret() {
//        return secret;
//    }
//
//    public void setSecret(String secret) {
//        this.secret = secret;
//    }
//
//    public Long getExpiration() {
//        return expiration;
//    }
//
//    public void setExpiration(Long expiration) {
//        this.expiration = expiration;
//    }
//
//    public Long getRememberExpiration() {
//        return rememberExpiration;
//    }
//
//    public void setRememberExpiration(Long rememberExpiration) {
//        this.rememberExpiration = rememberExpiration;
//    }
//}