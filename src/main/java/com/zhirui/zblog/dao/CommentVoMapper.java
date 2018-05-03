package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Vo.CommentVo;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentVoMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(CommentVo record);

    int insertSelective(CommentVo record);

    CommentVo selectByPrimaryKey(Integer coid);

    int updateByPrimaryKeySelective(CommentVo record);

    int updateByPrimaryKeyWithBLOBs(CommentVo record);

    int updateByPrimaryKey(CommentVo record);
}
