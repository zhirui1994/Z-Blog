package com.zhirui.zblog.service;

import com.zhirui.zblog.dao.MetaVoMapper;
import com.zhirui.zblog.dto.MetaDto;
import com.zhirui.zblog.model.Vo.MetaVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MetaService {

    @Resource
    private MetaVoMapper metaDao;

    public MetaDto getMeta(String type, String name) {
        if (!StringUtils.isEmpty(type) && !StringUtils.isEmpty(name)) {
            return metaDao.selectDtoByNameAndType(name, type);
        }
        return null;
    }

    public List<MetaVo> getMetas(String types) {
        return null;
    }


}
