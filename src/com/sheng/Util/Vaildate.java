package com.sheng.Util;

public class Vaildate {
    public static boolean isString(String str){
        if (str==null||"".equals(str)){
            return false;
        }
        return true;
    }

    public static boolean isInt(String str){
        if (isString(str)){
            return str.matches("\\d+");
        }
        return false;
    }

    public static boolean isDouble(String str){
        if (isString(str)){
            return str.matches("\\d+(\\.\\d+)?");
        }
        return false;
    }

    public static  boolean idDate(String str){
        if (isString(str)){
            return str.matches("\\d{4}-\\d{2}-\\d{2}");
        }
        return false;
    }

    public static boolean isDateTime(String str){
        if (isString(str)){
            return str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        }
        return false;
    }

    //验证文件是否符合类型匹配
    public static  boolean isFile(String Rule[],String mime){
        if (!isString(mime)){
            return false;
        }
        for (int i=0;i<Rule.length;i++){
            if (mime.equalsIgnoreCase(Rule[i])){
                return true;
            }
        }
        return false;
    }
}
