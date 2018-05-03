package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVoMapper  {
    int insert(UserVo record);
    UserVo selectedByPrimaryKey(Integer uid);
    int updateByPrimaryKey(UserVo record);
    int updateByPrimaryKeySelective(UserVo record);
    int deleteByPrimaryKey(Integer uid);
}
