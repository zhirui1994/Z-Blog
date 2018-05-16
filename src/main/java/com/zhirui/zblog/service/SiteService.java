package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.AttachVoMapper;
import com.zhirui.zblog.dao.CommentVoMapper;
import com.zhirui.zblog.dao.ContentVoMapper;
import com.zhirui.zblog.model.Bo.ArchiveBo;
import com.zhirui.zblog.model.Bo.StatisticsBo;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.utils.DateKit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SiteService {

    @Resource
    private CommentVoMapper commentDao;

    @Resource
    private ContentVoMapper contentDao;

    @Resource
    private AttachVoMapper attachDao;

    public List<CommentVo> recentComments(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }

        List<CommentVo> byPage = commentDao.selectByPageWithBLOBs(limit);
        return byPage;
    }

    public List<ContentVo> recentContents(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }

        List<ContentVo> byPage = contentDao.selectByPage(limit);
        return byPage;
    }

    public CommentVo getComment(Integer cuid) {
        return null;
    }

    public StatisticsBo getStatistcs() {
        StatisticsBo statistics = new StatisticsBo();
        Long contentsCount = contentDao.count();
        Long commentsCount = commentDao.count();
        Long attachsCount = attachDao.count();
        Long linksCount = Long.valueOf(10);
        statistics.setArticles(contentsCount);
        statistics.setAttachs(attachsCount);
        statistics.setComments(commentsCount);
        statistics.setLinks(linksCount);
        return statistics;
    }

    public List<ArchiveBo> getArchives() {
        List<ArchiveBo> archives = contentDao.findReturnArchiveBo();
        if (archives != null) {
            archives.forEach(archive -> {
                String date = archive.getDate();
                Date sd = DateKit.dateFormat(date, "yyyy年MM月");
                int start = DateKit.getUnixTimeByDate(sd);
                int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH,  sd, 1)) -1;
            });
        }
        return null;
    }
}
