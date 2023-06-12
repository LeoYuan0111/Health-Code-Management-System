package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.VaccinationInfo;
import com.example.healthcodebe.entity.VaccinationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:49
 */
@Mapper
public interface VaccinationRecordMapper extends BaseMapper<VaccinationRecord> {
    void addVaccinationInfo(VaccinationRecord vaccinationRecord);

    List<VaccinationInfo> getVaccinationInfoById(String id);
}
