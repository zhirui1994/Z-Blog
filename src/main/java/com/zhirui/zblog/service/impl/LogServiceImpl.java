package com.zhirui.zblog.service.impl;

import com.zhirui.zblog.dao.LogVoMapper;
import com.zhirui.zblog.model.Vo.LogVo;
import com.zhirui.zblog.service.ILogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    @Resource
    private LogVoMapper logDao;

    @Override
    public void insertLog(LogVo logVo) {

    }

    @Override
    public void insertLog(String action, String data, String ip, Integer authorId) {

    }

    @Override
    public List<LogVo> getLogs(int page, int limit) {
        List<LogVo> logVos = logDao.selectByPage(page, limit);
        return logVos;
    }
}
