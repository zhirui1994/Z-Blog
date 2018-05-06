package com.zhirui.zblog.service;

import com.zhirui.zblog.model.Vo.LogVo;

import java.util.List;

public interface ILogService {

    void insertLog(LogVo logVo);

    void insertLog(String action, String data, String ip, Integer authorId);

    List<LogVo> getLogs(int page, int limit);
}
