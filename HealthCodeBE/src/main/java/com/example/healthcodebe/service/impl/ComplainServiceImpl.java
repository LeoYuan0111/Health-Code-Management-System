package com.example.healthcodebe.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.healthcodebe.entity.Complain;
import com.example.healthcodebe.mapper.ComplainMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.healthcodebe.service.ComplainService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

//import javax.annotation.Resource;
import java.util.*;
@Service
public class ComplainServiceImpl extends ServiceImpl<ComplainMapper, Complain> implements ComplainService {
    @Resource
    private ComplainMapper complainMapper;
    @Override
    public boolean addComplain(Complain complain){
        complainMapper.addComplain(complain);
        return true;
    }

    @Override
    public List<Complain> getComplainById(String id){
        List<Complain> ret_list = complainMapper.getComplainById(id);
        return ret_list;
    }

    @Override
    public void withDraw(String complain_id){
        complainMapper.withDraw(complain_id);
    }

    @Override
    public Complain getComplainByComplainId(String complain_id){
        return complainMapper.getComplainByComplainId(complain_id);
    }

    @Override
    public List<Complain> getComplainListByPage(@Param("condition") Map<String, Object> condition){
        Map<String, Object> condition_new = new HashMap<>();
        Integer offset = (Integer.valueOf(condition.get("page").toString()) - 1) *
                Integer.valueOf(condition.get("page_size").toString());
        condition_new.put("offset", offset);
        condition_new.put("result", Integer.valueOf(condition.get("result").toString()));
        condition_new.put("page_size", Integer.valueOf(condition.get("page_size").toString()));
        return complainMapper.getComplainListByPage(condition_new);
    }
    @Override
    public void dealComplain(@Param("condition") Map<String, Object> condition){
        Map<String, Object> condition_new = new HashMap<>();
        condition_new.put("reply", condition.get("reply").toString());
        condition_new.put("result", Integer.valueOf(condition.get("result").toString()));
        condition_new.put("complain_id", condition.get("complain_id").toString());
        complainMapper.dealComplain(condition_new);
    }
}
