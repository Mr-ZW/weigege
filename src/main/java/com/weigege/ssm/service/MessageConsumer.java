package com.weigege.ssm.service;

import com.weigege.ssm.utils.JSONMapper;
import com.weigege.ssm.entity.TmUser;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

public class MessageConsumer implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			String msg = new String(message.getBody(),"UTF-8");
			//TmUser tmUser = (TmUser)JSONMapper.jsonFromObject(msg, TmUser.class);
//			if(tmUser==null){
				System.out.println(msg);
			//}
			//System.out.println(tmUser);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
