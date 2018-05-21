package com.weigege.ssm.utils;

import com.weigege.ssm.entity.TmUser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JSONMapper {

	public static <T>Object jsonFromObject(String jsonStr, Class<T> clazz){
		try{
			JSONObject jsonObject = new JSONObject(jsonStr);
			Field[] fields = clazz.getDeclaredFields();
			Method[] declaredMethods = clazz.getDeclaredMethods();
			return getObject(clazz,fields,declaredMethods,jsonObject);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private static <T> T getObject(Class<T> clazz, Field[] fields, Method[] declaredMethods, JSONObject jsonObject) {
		T t = null;
		try {
			t = clazz.newInstance();  //创建对象
			for (Field field : fields) { //遍历对象中得字段
				String methodName = "set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length());
				Class<?> type = field.getType();
				String key = field.getName();
				for (Method method : declaredMethods) {
					if(method.getName().contains("get")){
						continue;
					}else{
						if(method.getName().equals(methodName)){
							if(type.getName().endsWith("Integer")){
								method.invoke(t,new Integer(jsonObject.getInt(key)));
								break;
							}else if(type.getName().endsWith("String")){
								method.invoke(t,new String(jsonObject.getString(key)));
								break;
							}else if(type.getName().endsWith("Double")){
								method.invoke(t,new Double(jsonObject.getDouble(key)));
								break;
							}else if(type.getName().endsWith("Boolean")){
								method.invoke(t,new Boolean(jsonObject.getBoolean(key)));
								break;
							}else if(type.getName().endsWith("Long")){
								method.invoke(t,new Long(jsonObject.getLong(key)));
								break;
							}else if(type.getName().endsWith("JSONObject")){
								//根据属性名称获取get方法然后获取返回类型以此调用jsonFromObject
								method.invoke(t,new JSONObject(jsonObject.getJSONObject(key)));
								break;
							}else if(type.getName().endsWith("JSONArray")){
								//根据属性名称获取get方法然后获取返回类型以此递归调用jsonFromObject
								method.invoke(t,new JSONArray(jsonObject.getJSONArray(key)));
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}


	public static void main(String[] args) {
		TmUser tmUser = new TmUser();
		tmUser.setUsername("张三");
		tmUser.setPassword("zhangsan");
		tmUser.setTelephone("13522222222");
		tmUser.setAddress("上海市嘉定区");
		tmUser.setEmail("zhangsan@qq.com");
		tmUser.setId(001);
		JSONObject jsonObject = new JSONObject(tmUser);
		String jsonStr = jsonObject.toString();
		Object o = JSONMapper.jsonFromObject(jsonStr, TmUser.class);
		System.out.println(o);
	}

}
