package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Vaccine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.healthcodebe.mapper.VaccineMapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:24
 */
public interface VaccineService extends IService<Vaccine> {
    boolean addVaccine(Vaccine vaccine);
}
