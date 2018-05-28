package com.zhirui.zblog.dao;

import com.zhirui.zblog.model.Vo.AttachVo;
import com.zhirui.zblog.model.Vo.AttachVoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachVoMapper {
    long count();

    List<AttachVo> selectByExample(AttachVoExample attachVoExample);
}
