package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.VaccinationInfo;
import com.example.healthcodebe.entity.VaccinationRecord;
import com.example.healthcodebe.mapper.VaccinationRecordMapper;
import com.example.healthcodebe.service.VaccinationRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:49
 */
@Service
public class VaccinationRecordServiceImpl extends ServiceImpl<VaccinationRecordMapper, VaccinationRecord> implements VaccinationRecordService {
    @Resource
    VaccinationRecordMapper vaccinationRecordMapper;

    @Override
    public void addVaccinationInfo(VaccinationRecord vaccinationRecord){
        vaccinationRecordMapper.addVaccinationInfo(vaccinationRecord);
    }
    @Override
    public List<VaccinationInfo> getVaccinationInfoById(String id){
        return vaccinationRecordMapper.getVaccinationInfoById(id);
    }
}
