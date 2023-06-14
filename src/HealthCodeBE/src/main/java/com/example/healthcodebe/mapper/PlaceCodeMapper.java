package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.PlaceCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:40:22
 */
@Mapper
public interface PlaceCodeMapper extends BaseMapper<PlaceCode> {
    PlaceCode getPlaceCodeById(String id);

    PlaceCode getNewPlaceCode(@Param("condition") Map<String, Object> condition);

    void addPlaceCode(PlaceCode placeCode);
}
