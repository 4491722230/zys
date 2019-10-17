package store.zys.form;



/**
 * @author: Lan
 * @date: 2019/4/8 16:03
 * @description:
 */

public class LoginUser {

    /**
     * 用户手机号码
     */
    private String usename;

    /**
     * 是否记住密码
     */
    private Boolean remember;

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

}
