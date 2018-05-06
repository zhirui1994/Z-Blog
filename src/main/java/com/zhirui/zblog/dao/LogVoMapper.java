package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Vo.LogVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogVoMapper {
    int insert(LogVo record);
    int insertSelective(LogVo record);
    int deleteByPrimaryKey(Integer id);
    LogVo selectByPrimaryKey(Integer id);
    List<LogVo> selectByPage(Integer page, Integer limit);
    int updateByPrimaryKey(LogVo logVo);
    int updateByPrimaryKeySelective(LogVo logVo);
}
