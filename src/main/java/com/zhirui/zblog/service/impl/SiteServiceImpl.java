package com.zhirui.zblog.service.impl;

import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.ISiteService;

import java.util.List;

public class SiteServiceImpl extends ISiteService {
    @Override
    public List<CommentVo> recentComments(int limit) {
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
