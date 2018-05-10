package com.zhirui.zblog.service;

import com.zhirui.zblog.model.Vo.ContentVo;

import java.util.List;

public interface IContentService {
    String publish(ContentVo content);
    List<ContentVo> getContents(Integer p, Integer limit);
    ContentVo getContent(String id);
    void updateContentByCid(ContentVo content);
    List<ContentVo> getArticles(Integer mid, Integer page, Integer limit);
    List<ContentVo> getArticles(String keyword, Integer page, Integer limit);
    String deleteByCid(Integer cid);
    String updateArticle(ContentVo content);
    void updateCtegory(String ordinal, String newCategory);
}