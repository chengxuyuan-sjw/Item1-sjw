package com.sheng.Session;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;
import java.io.Serializable;


public class RedisSessionDao /*extends EnterpriseCacheSessionDAO*/ {
    /*@Resource
    private RedisTemplate<String,Object> redisTemplate;
    //创建session并返回session数据


    @Override
    protected Serializable doCreate(Session session){
        System.out.println("doCreate"+session+"*******");
        Serializable sessionID= super.doCreate(session);
        //将创建好的sessionID序列传入redis数据库
        redisTemplate.opsForValue().set(sessionID.toString(),session,1800);
        return sessionID;
    }

    //根据sessionID读取session数据,此方法主要目的在于先去本地址读取session,如果没有
    //那么还有一种可能是此数据在别的服务器上,那么我们不能跨服务器读session,只能从redis
    //数据中查看是否有此sessionID,如果还没有表示时间到期,无session需要重新登陆
    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("doreadsession"+sessionId);
        Session session =super.doReadSession(sessionId);
        if (session==null){
            return (Session) redisTemplate.opsForValue().get(sessionId.toString());
        }
        return null;
    }

    //session有个存储时间,更新session的更新
    @Override
    protected void doUpdate(Session session) {
        System.out.println("doUpdate"+session+"*******");
        if (session!=null){ //如果更新的时候session还存在,那么还需要再去存数据库一次
            redisTemplate.opsForValue().set(session.getId().toString(),session,1800);
        }
        super.doUpdate(session);
    }

    //执行session的删除处理
    @Override
    protected void doDelete(Session session) {
        System.out.println("doDelete"+session+"**********");
        super.doDelete(session);
        redisTemplate.delete(session.getId().toString());
    }
*/

}
