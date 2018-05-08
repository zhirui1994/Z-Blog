package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVoMapper  {
    int insert(UserVo record);
    UserVo selectedByPrimaryKey(Integer uid);
    int updateByPrimaryKey(UserVo record);
    int updateByPrimaryKeySelective(UserVo record);
    int deleteByPrimaryKey(Integer uid);
    List<UserVo> login(String username, String password);
}
