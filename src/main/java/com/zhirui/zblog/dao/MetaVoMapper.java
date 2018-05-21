package com.zhirui.zblog.dao;

import com.zhirui.zblog.dto.MetaDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaVoMapper {
    MetaDto selectDtoByNameAndType(@Param("name") String name,@Param("type") String type);
}
