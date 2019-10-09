/*
package store.zys.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.springframework.util.ReflectionUtils.makeAccessible;

*/
/**
 * @Author: zengyusheng
 * @Date: 2019/9/24 10:55
 * @Version 1.0
 *//*

public abstract class Reflections {
    */
/**
     * 通过反射，获得Class定义中声明的泛型参数的类型，注意泛型必须定义在父类处
     * 如无法找到，返回Object.class
     *
     * @return the 返回第一个声明的泛型类型. 如果没有,则返回Object.class
     *//*


    @SuppressWarnings("unchecked")
    public static Class getClassGenericType(final Class clazz) {
        return getClassGenericType(clazz, 0);
    }

    */
/**
     * 通过反射，获得Class定义中声明的父类的泛型参数的类型，如无法找到返回Object.class
     *
     * @param clazz class类
     * @param index 获取第几个泛型参数的类型，默认为0，即第一个
     * @return 返回地index哥泛型参数的类型
     *//*

    public static Class getClassGenericType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    */
/**
     * 根据注解类型获取实体的Field
     * @param entityClass 实体类型
     * @param annotationClass 注解类型
     * @retur 返回第一个有改注解类型的field,如果没有返回Null
     *//*

    public static Field getFieldByAnnotation(Class entityClass, Class annotationClass) {
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if(field.getAnnotation(annotationClass) != null) {
                makeAccessible(field);
                return field;
            }
        }
        return null;
    }

    public static Field getField(Class entityClass, String fieldName) {
        try {
            Field field = entityClass.getDeclaredField(fieldName);
            makeAccessible(field);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

}
*/
