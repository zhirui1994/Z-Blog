package com.zhirui.zblog.service.impl;

import com.zhirui.zblog.dao.CommentVoMapper;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.ISiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SiteServiceImpl implements ISiteService {

    @Resource
    private CommentVoMapper commentDao;

    @Override
    public List<CommentVo> recentComments(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }

        List<CommentVo> byPage = commentDao.selectByPageWithBLOBs(limit);
        return byPage;
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
