package com.weigege.ssm.job;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstJob {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${mq.routingKey}")
	private String routingKey;

	public void execute() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		rabbitTemplate.convertAndSend(routingKey,"Quartz任务调度===!Current Time:"+simpleDateFormat.format(new Date()));
		this.sout();
	}

	public void sout(){
		System.out.println("测试JRebel添加方法！！！");
	}
}
