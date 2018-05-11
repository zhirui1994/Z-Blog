package com.zhirui.zblog.model.Bo;

import com.zhirui.zblog.model.Vo.CommentVo;

import java.util.List;

public class CommentBo extends CommentVo {
    private int levels;
    private List<CommentVo> children;
    public CommentBo(CommentVo comment) {
        setAuthor(comment.getAuthor());
        setMail(comment.getMail());
        setCoid(comment.getCoid());
        setAuthorId(comment.getAuthorId());
        setUrl(comment.getUrl());
        setCreated(comment.getCreated());
        setAgent(comment.getAgent());
        setIp(comment.getIp());
        setContent(comment.getContent());
        setOwnerId(comment.getOwnerId());
        setCid(comment.getCid());
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public void setChildren(List<CommentVo> children) {
        this.children = children;
    }

    public List<CommentVo> getChildren() {
        return this.children;
    }
}
