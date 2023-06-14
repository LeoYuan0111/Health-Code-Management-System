package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.VaccinationInfo;
import com.example.healthcodebe.entity.VaccinationRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:49
 */
public interface VaccinationRecordService extends IService<VaccinationRecord> {
    void addVaccinationInfo(VaccinationRecord vaccinationRecord);

    List<VaccinationInfo> getVaccinationInfoById(String id);
}
