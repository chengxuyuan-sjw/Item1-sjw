package com.sheng.Util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * 专门进行图片处理的类
 */
public class PhotoVaildate {
   public static boolean isMime(Object o, HttpServletRequest request) throws Exception{
       MultipartResolver mr=new CommonsMultipartResolver();//获得上传文件的处理类
       if (mr.isMultipart(request)){ //isMultipart验证是否有上传文件
            //获取配置文件里的信息
          String  rule=MessageUtil.getMessage(o,"mimeType");
          String rules[]=rule.split("\\|");
          if (rule==null||"".equals(rule)){
              return true;//没有配置信息,即没有要求,放行
          }else {
              //将request强转成MulipartRequest,MulipartRequest是解析请求的类
              MultipartRequest Mp=(MultipartRequest) request;
              //MulitipartFile(请求解析类)中的getFileMap,以map的形式接收上传的文件
              Map<String, MultipartFile> map=Mp.getFileMap();
              if (map.size()>0){ //证明map存入文件信息
                  Iterator<Map.Entry<String,MultipartFile>> iter=map.entrySet().iterator();
                  while (iter.hasNext()){
                      //Map.entry是set集合的一种,表示map集合中的一个Key和一个value(也就是一个键值对)
                      Map.Entry<String,MultipartFile> photoDeatils=iter.next();
                      //System.out.println("文件信息:"+photoDeatils.getKey()+"文件大小"+photoDeatils.getValue().getSize());
                      if (!Vaildate.isFile(rules,photoDeatils.getValue().getContentType())){
                          return false;
                      }
                  }

              }
          }
       }
    return true;
   }
}
