package store.zys.form;


/**
 * @author: Lan
 * @date: 2019/4/8 15:41
 * @description:登录请求参数
 */

public class LoginForm extends LoginUser {

    /**
     * 用户密码
     */
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
