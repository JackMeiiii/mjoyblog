package com.meihf.mjoyblog.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SpringSheduleQuartz implements Job{

	public void sheduleQuartz(){
		System.out.println("Quartz��ʱ�������");
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		sheduleQuartz();
	}
	
}
