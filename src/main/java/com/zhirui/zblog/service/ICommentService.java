package com.zhirui.zblog.service;

import com.zhirui.zblog.model.Vo.CommentVo;

import java.util.List;

public interface ICommentService {
    String insertComment(CommentVo commentVo);
    List<CommentVo> getComments(Integer cid, int page, int limit);
}
