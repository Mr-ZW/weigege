package com.weigege.ssm.web;
import com.weigege.ssm.entity.TmUser;
import com.weigege.ssm.mapper.TmUserMapper;
import com.weigege.ssm.service.TmUserService;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@Autowired
	private TmUserService tmUserService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Value("${mq.routingKey}")
	private String routingKey;

	@RequestMapping("/index")
	public String index(){
		TmUser tmUser = tmUserService.selectByPrimaryKey(1);
		rabbitTemplate.convertAndSend(routingKey, new JSONObject(tmUser).toString());
		System.out.println(tmUser.getUsername());
		return "index";
	}

}
