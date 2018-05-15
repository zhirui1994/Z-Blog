package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.ContentVoMapper;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentService {

    @Resource
    private ContentVoMapper contentDao;

    public String publish(ContentVo content) {
        return null;
    }

    public List<ContentVo> getContents(Integer p, Integer limit) {
        List<ContentVo> contents =  contentDao.selectByPage(limit);
        return contents;
    }

    public ContentVo getContent(String id) {

        ContentVo content = contentDao.selectByPrimaryKey(Integer.parseInt(id));
        return content;
    }

    public void updateContentByCid(ContentVo content) {

    }

    public List<ContentVo> getArticles(Integer mid, Integer page, Integer limit) {
        return null;
    }

    public List<ContentVo> getArticles(String keyword, Integer page, Integer limit) {
        return null;
    }

    public String deleteByCid(Integer cid) {
        return null;
    }

    public String updateArticle(ContentVo content) {
        return null;
    }

    public void updateCtegory(String ordinal, String newCategory) {

    }
}
