package com.example.healthcodebe.mapper;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.Complain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface ComplainMapper extends BaseMapper<Complain> {
    void addComplain(Complain complain);
    List<Complain> getComplainById(String id);
    void withDraw(String complain_id);
    Complain getComplainByComplainId(String complain_id);

    List<Complain> getComplainListByPage(@Param("condition") Map<String, Object> condition);
    void dealComplain(@Param("condition") Map<String, Object> condition);
}
