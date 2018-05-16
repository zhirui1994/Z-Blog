package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.CommentVoMapper;
import com.zhirui.zblog.model.Vo.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentVoMapper commentDao;

    public String insertComment(CommentVo commentVo) {
        return null;
    }

    public List<CommentVo> getComments(Integer cid, int page, int limit) {
       List<CommentVo> comments = commentDao.selectByPageWithBLOBs(limit);
       return comments;
    }
}
