package com.kingstar.managementinfo.dao;

import com.kingstar.managementinfo.dao.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(int id);
    int insert(User record);
    User selectByPrimaryKey(int id);
    int updateByPrimaryKeySelective(User record);

}
