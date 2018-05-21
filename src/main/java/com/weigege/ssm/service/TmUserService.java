package com.weigege.ssm.service;

import com.weigege.ssm.entity.TmUser;

public interface TmUserService {

	int insert(TmUser record);

	int insertSelective(TmUser record);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TmUser record);

	int updateByPrimaryKey(TmUser record);

	TmUser selectByPrimaryKey(Integer id);

}
