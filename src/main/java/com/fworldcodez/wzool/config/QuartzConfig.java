package com.fworldcodez.wzool.config;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask scheduleTask) {
        //需要执行任务
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        /*
        * 是否并发执行
        * 例如 每5秒执行一次，但当前任务还没执行完，就已经过了5秒钟
        * 如果此次为true，则下一个任务会并执行。如果此处为false，则下一个任务会等待上一个任务执行完后，再执
        * 行*/
        jobDetailFactoryBean.setConcurrent(false);
        jobDetailFactoryBean.setName("scheduler");//设置任务名
        jobDetailFactoryBean.setGroup("scheduler_group");//设置任务分组，这些可以存储在数据库中，在执行多任务的时候使用
        /*
        * 要执行的任务*/
        jobDetailFactoryBean.setTargetObject(scheduleTask);
        jobDetailFactoryBean.setTargetMethod("messageSend");
        return jobDetailFactoryBean;
    }
/**
 * 触发器
 * */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail.getObject());
        trigger.setCronExpression("0/6 * * * * ?");//cron表达式,每6秒执行一次
        trigger.setName("trigger");//trigger 的name
        return trigger;
    }
@Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronTrigger){
        SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();
        //设置是否任意一个已定义的job会覆盖现在的job,默认false，即已定义的Job不会覆盖现有的Job
    schedulerFactoryBean.setOverwriteExistingJobs(true);
    //延时启动，应用启动5秒后,定时请动任务
    schedulerFactoryBean.setStartupDelay(10);
    //注册定时触发器
    schedulerFactoryBean.setTriggers(cronTrigger);
    return schedulerFactoryBean;
}

    //多任务时的Scheduler，动态设置Trigger。一个SchedulerFactoryBean可能会有多个Trigger
    @Bean(name = "multitaskScheduler")
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
}
