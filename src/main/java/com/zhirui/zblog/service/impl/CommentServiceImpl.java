package com.zhirui.zblog.service.impl;

import com.zhirui.zblog.dao.CommentVoMapper;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentVoMapper commentDao;

    @Override
    public String insertComment(CommentVo commentVo) {
        return null;
    }

    @Override
    public List<CommentVo> getComments(Integer cid, int page, int limit) {
       List<CommentVo> comments = commentDao.selectByPageWithBLOBs(limit);
       return comments;
    }
}
