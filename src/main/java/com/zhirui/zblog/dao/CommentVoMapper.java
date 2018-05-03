package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.CommentVoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentVoMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(CommentVo record);

    int insertSelective(CommentVo record);

    CommentVo selectByPrimaryKey(Integer coid);

    List<CommentVo> selectByExampleWithBLOBs(CommentVoExample example);

    List<CommentVo> selectByExample(CommentVoExample example);

    int updateByPrimaryKeySelective(CommentVo record);

    int updateByPrimaryKeyWithBLOBs(CommentVo record);

    int updateByPrimaryKey(CommentVo record);

    List<CommentVo> selectByPageWithBLOBs(int limit);
}
