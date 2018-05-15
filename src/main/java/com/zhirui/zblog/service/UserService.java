package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.UserVoMapper;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.IUserService;
import com.zhirui.zblog.utils.TaleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Resource
    private UserVoMapper userDao;

    @Override
    public Integer insertUser(UserVo userVo) {
        return null;
    }

    @Override
    public UserVo queryUserById(Integer uid) {
        UserVo userVo = null;
        if (uid != null) {
            userVo = userDao.selectedByPrimaryKey(uid);
        }
        return userVo;
    }

    @Override
    public UserVo login(String username, String password) {
        String pwd = TaleUtils.MD5encode(username + password);
        List<UserVo> users = userDao.login(username, pwd);
        return users.get(0);
    }

    @Override
    public void updateByUid(UserVo userVo) {

    }
}
