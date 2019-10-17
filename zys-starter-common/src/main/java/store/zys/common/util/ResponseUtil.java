package store.zys.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: Lan
 * @date: 2019/4/8 15:46
 * @description:返回前台
 */

public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o) {
        //Logger log = LoggerFactory.getILoggerFactory();
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            //json返回
            out.println(JSON.toJSONString(o, SerializerFeature.WriteMapNullValue));
            out.flush();
            out.close();
        } catch (Exception e) {
           // log.error("e={}", e);
        }
    }
}
