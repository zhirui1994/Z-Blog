package com.zhirui.zblog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.dao.ContentVoMapper;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.model.Vo.ContentVoExample;
import com.zhirui.zblog.utils.DateKit;
import com.zhirui.zblog.utils.TaleUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentService {

    @Resource
    private ContentVoMapper contentDao;

    @Resource
    private MetaService metaService;

    public String publish(ContentVo content) {
        if (content == null) {
            return "文章对象为空";
        }
        if (StringUtils.isEmpty(content.getTitle())) {
            return "文章标题不能为空";
        }
        if (StringUtils.isEmpty(content.getContent())) {
            return "文章内容不能为空";
        }
        int titleLength = content.getTitle().length();
        if (titleLength > WebConst.MAX_TITLE_COUNT) {
            return "文章标题过长";
        }
        if (!StringUtils.isEmpty(content.getSlug())) {
            if (content.getSlug().length() < 5) {
                return "路径太短了";
            }
//            if (!TaleUtils.isPath(content.getSlug())) {
//                return "您输入的路径不合法";
//            }
        } else {
            content.setSlug(null);
        }

//        content.setContent();
        int time = DateKit.getCurrentUnixTime();
        content.setCreated(time);
        content.setModified(time);
        content.setHits(0);
        content.setCommentsNum(0);

        String tags = content.getTags();
        String categories = content.getCategories();
        contentDao.insert(content);
//        Integer cid content.getCid();
//        metaService.save
        return WebConst.SUCCESS_RESULT;
    }

    public List<ContentVo> getContents(Integer p, Integer limit) {
        List<ContentVo> contents =  contentDao.selectByPage(limit);
        return contents;
    }

    public PageInfo<ContentVo> getArticlesWithPage(ContentVoExample contentVoExample, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ContentVo> contentVos = contentDao.selectByExampleWithBLOBs(contentVoExample);
        return new PageInfo<>(contentVos);
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
        if (content == null) {
            return "文章对象为空";
        }
        if (StringUtils.isEmpty(content.getTitle())) {
            return "文章标题不能为空";
        }
        if (StringUtils.isEmpty(content.getContent())) {
            return "文章内容不能为空";
        }
        int titleLength = content.getTitle().length();
        if (titleLength > WebConst.MAX_TITLE_COUNT) {
            return "文章标题过长";
        }

        if (content.getAuthorId() == null) {
            return "请登录后发布文章";
        }

        if (StringUtils.isEmpty(content.getSlug())) {
            content.setSlug(null);
        }
        int time = DateKit.getCurrentUnixTime();
        content.setModified(time);
        Integer cid = content.getCid();
        contentDao.updateByprimaryKeySelective(content);
        return WebConst.SUCCESS_RESULT;
    }

    public void updateCtegory(String ordinal, String newCategory) {

    }
}
