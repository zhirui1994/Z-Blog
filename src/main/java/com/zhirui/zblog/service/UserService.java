package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.UserVoMapper;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.utils.TaleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserVoMapper userDao;

    public Integer insertUser(UserVo userVo) {
        return null;
    }

    public UserVo queryUserById(Integer uid) {
        UserVo userVo = null;
        if (uid != null) {
            userVo = userDao.selectedByPrimaryKey(uid);
        }
        return userVo;
    }

    public UserVo login(String username, String password) {
        String pwd = TaleUtils.MD5encode(username + password);
        List<UserVo> users = userDao.login(username, pwd);
        return users.get(0);
    }

    public void updateByUid(UserVo userVo) {

    }
}
