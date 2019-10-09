package store.zys.common.exception;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/23 13:40
 * @Version 1.0
 */
public class ServiceException extends BaseException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }
}
