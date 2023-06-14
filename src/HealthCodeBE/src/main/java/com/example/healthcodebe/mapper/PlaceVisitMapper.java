package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.Id;
import com.example.healthcodebe.entity.PlaceVisit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.healthcodebe.entity.PlaceVisitInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:40:52
 */
@Mapper
public interface PlaceVisitMapper extends BaseMapper<PlaceVisit> {
    List<PlaceVisitInfo> getPlaceVisitInfoById(String id);

    void addPlaceVisit(PlaceVisit placeVisit);

    List<Id> getCloseContactById(String id);
}
