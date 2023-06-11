package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.healthcodebe.entity.Complain;

import java.util.List;
import java.util.Map;
public interface ComplainService  extends IService<Complain>{
    boolean addComplain(Complain complain);
    List<Complain> getComplainById(String id);

    void withDraw(String complain_id);
    Complain getComplainByComplainId(String complain_id);
}
