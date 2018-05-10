package com.zhirui.zblog.service.impl;

import com.zhirui.zblog.dao.ContentVoMapper;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements IContentService {

    @Resource
    private ContentVoMapper contentDao;

    @Override
    public String publish(ContentVo content) {
        return null;
    }

    @Override
    public List<ContentVo> getContents(Integer p, Integer limit) {
        List<ContentVo> contents =  contentDao.selectByPage(limit);
        return contents;
    }

    @Override
    public ContentVo getContent(String id) {
        return null;
    }

    @Override
    public void updateContentByCid(ContentVo content) {

    }

    @Override
    public List<ContentVo> getArticles(Integer mid, Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<ContentVo> getArticles(String keyword, Integer page, Integer limit) {
        return null;
    }

    @Override
    public String deleteByCid(Integer cid) {
        return null;
    }

    @Override
    public String updateArticle(ContentVo content) {
        return null;
    }

    @Override
    public void updateCtegory(String ordinal, String newCategory) {

    }
}
