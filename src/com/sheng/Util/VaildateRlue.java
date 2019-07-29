package com.sheng.Util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个错误总成类,把错误分支util类的每个方法进行组成
 * 用以验证各项数据是否有错,有错即将错误收集起来,返回于拦截器中,使
 * 拦截器进行拦截操作,并把配置文件中对应错误的提示信息返回到拦截器中
 */
public class VaildateRlue {
    public String Rule[];
    public Object o;
    public HttpServletRequest request;
    public VaildateRlue(Object o,String Rule[],HttpServletRequest request){
        this.Rule=Rule;
        this.o=o;
        this.request=request;
    }
    public Map<String,String> vaildate() {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < Rule.length; i++) {
            String Temp[] = Rule[i].split(":");
            String paramValue = request.getParameter(Temp[0]);
            switch (Temp[1]) {
                case ("String"): {
                    if (!Vaildate.isString(paramValue)) { //如果验证失败
                        try {
                            //利用Util包中自定义的反射机制方法,获取配置信息
                            String context = MessageUtil.getMessage(this.o, "invaildate.String.error.msg");
                            map.put(Temp[0], context);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    break;
                }
                case ("int"): {
                    if (!Vaildate.isInt(paramValue)) {
                        try {
                            String context = MessageUtil.getMessage(this.o, "invaildate.int.error.msg");
                            map.put(Temp[0], context);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }

        }
        return map;
    }

}
