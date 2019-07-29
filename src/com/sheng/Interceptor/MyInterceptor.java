package com.sheng.Interceptor;

import com.sheng.Util.MessageUtil;
import com.sheng.Util.PhotoVaildate;
import com.sheng.Util.VaildateRlue;
import org.springframework.context.MessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

/**
 * 定义SpringMVC中的拦截器(Interceptor),继承于HandlerInterceptor
 */

/**
 * 拦截器和filter不同在于,过滤器只有在容器启动的时候,执行一次,一般为过滤敏感词汇,
 * 过滤编码格式,但是拦截器,可以启动多次,拦截器执行在到控制层(action)前的数据拦截,判断是否
 * 符合预期,例如,是否登陆
 */

/**
 * 拦截器需要实现HanlerInterceptor接口的三个方法:
 * 1.preHandle:Action方法执行前触发
 * 2.postHandle:Action方法执行中触发
 * 3.afterCompletion:Action方法执行后触发 如处理Action产生的异常
 */

/**
 * 在拦截器中,核心方法就是 HandlerMethod类,此类有很多高效实用的方法,如
 * getBean(),获得触发此拦截器的程序类  getBeanType(),获得触发此拦截器的Bean的类型
 * getMethod(),获得触发此拦截器中的程序类中对应的方法
 * getMethodParameters(),获得触发拦截器的方法参数集合
 */

/**
 * 返回true是放行,false是不放心
 */
public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object hander) throws Exception {
          HandlerMethod handlerMethod=(HandlerMethod) hander;
          //1.平凑规则名
          String rulename=handlerMethod.getBeanType().getSimpleName()+"."+handlerMethod.getMethod().getName()+".rules";
          //2.利用反射找到所拦截Action类内的获得信息的方法
          Method method=handlerMethod.getBean().getClass().getDeclaredMethod("getMessage",String.class);
          //3.查询Properties定义的验证信息(invoke第一个传递是调用该方法的对象,第二个是传递方法需要的参数)
          String Message=(String) method.invoke(handlerMethod.getBean(),rulename);
          //4.判断此拦截类中是否存在rule信息,不存在则意味着不需要执行验证,放心
          if ("".equals(Message)||Message==null){
              return true;//放行
          }else {
              //5.拆分规则
              String rules[]=Message.split("\\|");
              //6交给公共类VaildateRule验证,如果有错误会返回错误信息
              Map<String,String> map=new VaildateRlue(handlerMethod.getBean(),rules,request).vaildate();
              if (map.size()>0){
                  //7.将错误信息map输出到页面,并且传送到错误页面上
                  request.setAttribute("map",map);
                  request.getRequestDispatcher("/Emp-add-error.jsp").forward(request,response);
                  return false;
              }else {
                  //8.验证图片信息,交给Util包中的验证图片类
                 if(!PhotoVaildate.isMime(handlerMethod.getBean(),request)) {
                     //通过反射找到获取信息的方法, 获取图片信息错误内容
                     String errorMessage= MessageUtil.getMessage(handlerMethod.getBean(),"invaildate.mime.error.msg");
                     request.setAttribute("error",errorMessage);
                     request.getRequestDispatcher("/Emp-add-error.jsp").forward(request,response);
                      return true;
                  }else {
                      return false;
                  }
              }

          }


    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object hander, ModelAndView mv) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object hander,
                                Exception e) throws Exception {

    }
}
