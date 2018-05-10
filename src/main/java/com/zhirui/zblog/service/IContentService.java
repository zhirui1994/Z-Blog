package com.zhirui.zblog.service;

import com.zhirui.zblog.model.Vo.ContentVo;

import java.util.List;

public interface IContentService {
    String publish(ContentVo content);
    List<ContentVo> getContents(Integer p, Integer limit);
    ContentVo getContent(String id);
    void updateContentByCid(ContentVo content);
}