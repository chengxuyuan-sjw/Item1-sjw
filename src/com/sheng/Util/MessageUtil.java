package com.sheng.Util;

import java.lang.reflect.Method;

/**
 * 此类的作用是专门读取properties配置文件内容的util类
 */
public class MessageUtil {
    //在此反射机制中需要复习的是两点内容,一是调用方法,getMethod和getDeclaredMethod方法的区别
    //区别在于getMethod是只能调用公共方法,而getDeclaredMethod是调用所有的包括private私有的
    //第二点在于,getMethod(),除了需要给方法名,还需要给返回值的类型的类
    //第三点在于,Invoke()方法调用方法时候,返回的都是Object类型,如果有其他的需要,需要强转
    public static String getMessage(Object obj,String key){
        try {
        //1.利用反射机制找到调用此util类的类中的获取配置文件的方法
        Method method=obj.getClass().getDeclaredMethod("getMessage",String.class);
        //2.利用反射机制的invoke方法,执行找到的Method方法,并且返回找到的配置信息
        return (String) method.invoke(obj,key);
        }catch (Exception e){
            e.printStackTrace();
            return null;   //无错误返回Message有错误返回null
        }

    }
}
