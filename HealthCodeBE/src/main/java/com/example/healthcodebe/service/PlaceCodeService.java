package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.PlaceCode;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:40:22
 */
public interface PlaceCodeService extends IService<PlaceCode> {
    PlaceCode getPlaceCodeById(String id);

    PlaceCode getNewPlaceCode(@Param("condition") Map<String, Object> condition);

    void addPlaceCode(PlaceCode placeCode);
}
