package com.meihf.mjoyblog.spring.task;

import org.springframework.stereotype.Component;

@Component("springTaskShedule")
public class SpringSheduleConfiguration {
	
	public void springShedule(){
		System.out.println("配置文件方式启动定时任务");
	}

}
