package com.weigege.ssm.service.impl;

import com.weigege.ssm.entity.TmUser;
import com.weigege.ssm.mapper.TmUserMapper;
import com.weigege.ssm.service.TmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmUserServiceImpl implements TmUserService {

	@Autowired
	private TmUserMapper tmUserMapper;

	@Override
	public int insert(TmUser record) {
		return tmUserMapper.insert(record);
	}

	@Override
	public int insertSelective(TmUser record) {
		return tmUserMapper.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return tmUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TmUser record) {
		return tmUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TmUser record) {
		return tmUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public TmUser selectByPrimaryKey(Integer id) {
		return tmUserMapper.selectByPrimaryKey(id);
	}
}
