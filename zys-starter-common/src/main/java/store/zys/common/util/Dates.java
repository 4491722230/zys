package store.zys.common.util;



import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @Author: zengyusheng
 * @Date: 2019/9/23 11:03
 * @Version 1.0
 */
public class Dates {
    /**
     * 日期时间匹配格式
     */

    interface Pattern {
        //
        //常规模式
        //------------------------------------------------------------------
        /**
         * yyyy-MM-dd
         */
        String DATE = "yyyy-MM-dd";

        /**
         * yyyy-MM-dd HH:mm:ss
         */
        String DATETIME = "yyyy-MM-dd HH:mm:ss";

        /**
         * yyyy-MM-dd HH:mm
         */
        String DATETIME_MM = "yyyy-MM-dd HH:mm";
        /**
         * yyyy-MM-dd HH:mm:ss.SSS
         */
        String DATETIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

        /**
         * HH:mm
         */
        String TIME = "HH:mm";

        /**
         * HH;mm:ss
         */
        String TIME_SS = "HH:mm:ss";

        // 系统时间格式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyy/MM/dd
         */
        String SYS_DATE = "yyyy/MM/dd";

        /**
         * yyyy/MM/dd HH:mm:ss
         */
        String SYS_DATETIME = "yyyy/MM/dd HH:mm:ss";

        String SYS_DATETIME_MM = "yyyy/MM/dd HH:mm";
        /**
         * yyyy/MM/dd HH:mm:ss.SSS
         */
        String SYS_DATETIME_SSS = "yyyy/MM/dd HH:mm:ss.SSS";

        //
        // 无连接符模式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyyMMdd
         */
        String NONE_DATE = "yyyyMMdd";
        /**
         * yyyyMMddHHmmss
         */
        String NONE_DATETIME = "yyyyMMddHHmmss";
        /**
         * yyyyMMddHHmm
         */
        String NONE_DATETIME_MM = "yyyyMMddHHmm";
        /**
         * yyyyMMddHHmmssSSS
         */
        String NONE_DATETIME_SSS = "yyyyMMddHHmmssSSS";

    }

    public static final String DEFAULT_PATTERN = Pattern.DATETIME;
    public static final String[] PARSE_PATTERNS = new String[]{
            Pattern.DATE,
            Pattern.DATETIME,
            Pattern.DATETIME_SSS,
            Pattern.DATETIME_MM,
            Pattern.SYS_DATE,
            Pattern.SYS_DATETIME,
            Pattern.SYS_DATETIME_MM,
            Pattern.SYS_DATETIME_SSS
    };

    /**
     * 格式化日期
     *
     * @Param data 日期时间
     * @Param pattern 匹配模式
     * @Return 格式化后的字符串
     */

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        pattern = StringUtils.isNotBlank(pattern) ? pattern : DEFAULT_PATTERN;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 解析日期
     *
     * @return 解析后的日期，默认格式 yyyy-MM-dd HH:mm:ss
     * @Param date 日期字符串
     */

    public static Date parseDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            return DateUtils.parseDate(date, PARSE_PATTERNS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析日期
     *
     * @param date    日期
     * @param pattern 格式 参考：{@link Dates.Pattern}
     * @return 解析后的日期，默认格式：yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDate(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        String[] parsePatterns;
        parsePatterns = StringUtils.isNotBlank(pattern) ? new String[]{pattern} : PARSE_PATTERNS;
        try {
            return DateUtils.parseDate(date, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
