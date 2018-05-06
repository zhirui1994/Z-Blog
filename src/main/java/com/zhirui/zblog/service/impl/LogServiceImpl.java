package com.zhirui.zblog.service.impl;

import com.zhirui.zblog.model.Vo.LogVo;
import com.zhirui.zblog.service.ILogService;

import java.util.List;

public class LogServiceImpl implements ILogService {
    @Override
    public void insertLog(LogVo logVo) {

    }

    @Override
    public void insertLog(String action, String data, String ip, Integer authorId) {

    }

    @Override
    public List<LogVo> getLogs(int page, int limit) {
        return null;
    }
}
