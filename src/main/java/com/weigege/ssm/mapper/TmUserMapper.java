package com.weigege.ssm.mapper;

import com.weigege.ssm.entity.TmUser;

public interface TmUserMapper {

    int insert(TmUser record);

    int insertSelective(TmUser record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmUser record);

    int updateByPrimaryKey(TmUser record);

    TmUser selectByPrimaryKey(Integer id);
}