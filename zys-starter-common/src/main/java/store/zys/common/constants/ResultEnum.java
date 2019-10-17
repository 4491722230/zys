package store.zys.common.constants;

/**
 * @author: Lan
 * @date: 2019/4/8 15:38
 * @description:错误枚举类
 */

public enum ResultEnum {
    ACCESS_NOT(501, "权限不足"),

    TOKEN_IS_NOT_VALID(502, "token无效，请重新登录"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
