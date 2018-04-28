package com.zhirui.zblog.service;

import com.zhirui.zblog.model.Vo.UserVo;

public interface IUserService {
    Integer insertUser(UserVo userVo);

    UserVo queryUserById(Integer uid);

    UserVo login(String username, String password);

    void updateByUid(UserVo userVo);
}
