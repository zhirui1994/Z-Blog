package com.zhirui.zblog.service;

import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;

import java.util.List;

public interface ISiteService {
    /**
     * 最新收到的评论
     * @param limit 条数
     * @return
     */
    List<CommentVo> recentComments(int limit);

    /**
     * 最新发表的文章
     * @param limit 条数
     * @return
     */
    List<ContentVo> recentContents(int limit);

    /**
     * 查询一条评论
     * @param cuid 评论的id
     * @return
     */
    CommentVo getComment(Integer cuid);
}
