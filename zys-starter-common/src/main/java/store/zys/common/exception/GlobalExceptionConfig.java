package store.zys.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import store.zys.common.base.Result;
import store.zys.common.constants.BaseEnums;
import store.zys.common.util.Results;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/26 9:35
 * @Version 1.0
 */
public class GlobalExceptionConfig {
    /**
     * 处理 ServiceException 异常
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionConfig.class);
    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        Result result = Results.failure(e.getCode(), e.getMessage());
        result.setStatus(HttpStatus.BAD_REQUEST.value());
        logger.info("ServiceException[code: {}, message: {}]", e.getCode(), e.getMessage());
        return result;
    }

    /**
     * 处理 AuthorityException 异常
     */
    @ExceptionHandler(AuthorityException.class)
    public Result handleAuthorityException(AuthorityException e) {
        Result result = Results.failure(BaseEnums.FORBIDDEN.code(), BaseEnums.FORBIDDEN.desc());
        result.setStatus(HttpStatus.FORBIDDEN.value());
        logger.info("AuthorityException[code: {}, message: {}]", e.getCode(), e.getMessage());
        return result;
    }

    /**
     * 处理 NoHandlerFoundException 异常. <br/>
     * 需配置 [spring.resources.add-mappings=false]
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handleNotFoundException(NoHandlerFoundException e) {
        Result result = Results.failure(BaseEnums.NOT_FOUND.code(), BaseEnums.NOT_FOUND.desc());
        result.setStatus(HttpStatus.NOT_FOUND.value());
        logger.info(e.getMessage());
        return result;
    }

    /**
     * 处理 BaseException 异常
     */


    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException e) {
        Result result = Results.failure(e.getCode(), e.getMessage());
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error("BaseException[code: {}, message: {}]", e.getCode(), e.getMessage(), e);
        return result;
    }

    /**
     * 处理 Exception 异常
     */
    @ExceptionHandler(Exception.class)
    Result handleException(Exception e) {
        Result result = Results.failure(BaseEnums.ERROR.code(), BaseEnums.ERROR.desc());
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error(e.getMessage(), e);
        return result;
    }
}
