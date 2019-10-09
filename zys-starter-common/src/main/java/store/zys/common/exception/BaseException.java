package store.zys.common.exception;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/23 13:36
 * @Version 1.0
 */
public class BaseException extends RuntimeException {
    /**
     * 错误编码
     */
    protected String code;

    public BaseException () {}

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
