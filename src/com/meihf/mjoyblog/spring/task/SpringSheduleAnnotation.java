package com.meihf.mjoyblog.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringSheduleAnnotation {

	@Scheduled(cron = "0/1 * * * * ?")
	public void testShedule(){
		System.out.println("注解方式启动定时任务");
	}
}
