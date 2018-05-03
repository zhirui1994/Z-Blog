package com.zhirui.zblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhirui.zblog.dao.CommentVoMapper;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.CommentVoEXample;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.ISiteService;

import javax.annotation.Resource;
import java.util.List;

public class SiteServiceImpl extends ISiteService {

    @Resource
    private CommentVoMapper commentDao;

    @Override
    public List<CommentVo> recentComments(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        CommentVoEXample eXample = new CommentVoEXample();
        eXample.setOrderByClause("created desc");
        PageHelper.startPage(1, limit);
        List<CommentVo> byPage == commentDao.sel
        return null;

    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        return null;
    }

    @Override
    public CommentVo getComment(Integer cuid) {
        return null;
    }
}
