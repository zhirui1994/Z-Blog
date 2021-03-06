package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Bo.ArchiveBo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.model.Vo.ContentVoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentVoMapper {

    int insert(ContentVo record);

    int insertSelective(ContentVo record);

    int deleteByprimaryKey(Integer cid);

    ContentVo selectByPrimaryKey(Integer cid);

    List<ContentVo> selectByPage(Integer limit);

    List<ContentVo> selectByExample(ContentVoExample example);

    int updateByPrimaryKey(ContentVo record);

    int updateByprimaryKeySelective(ContentVo record);

    long count();

    List<ArchiveBo> findReturnArchiveBo();

    List<ContentVo> selectByExampleWithBLOBs(ContentVoExample contentVoExample);
}
