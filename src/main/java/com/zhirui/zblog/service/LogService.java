package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.LogVoMapper;
import com.zhirui.zblog.model.Vo.LogVo;
import com.zhirui.zblog.service.ILogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogService {

    @Resource
    private LogVoMapper logDao;

    public void insertLog(LogVo logVo) {

    }

    public void insertLog(String action, String data, String ip, Integer authorId) {

    }

    public List<LogVo> getLogs(int page, int limit) {
        List<LogVo> logVos = logDao.selectByPage(page, limit);
        return logVos;
    }
}
