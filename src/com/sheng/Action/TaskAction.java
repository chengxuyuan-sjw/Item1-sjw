package com.sheng.Action;


import com.sheng.Service.back.ITravelServiceBack;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 负责定时调度的Action
 */
@Component
public class TaskAction {
    @Resource(name = "ITravelServiceBackImpl")
    private ITravelServiceBack serviceBack;
    //@Scheduled(cron = "* * * * * ?")  每秒进行更新
    @Scheduled(cron="0 0 0 * * ?")  //每晚12点进行更新
    public void run(){
        serviceBack.UpdateTask(new Date());
    }
}
