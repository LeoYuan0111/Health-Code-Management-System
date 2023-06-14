package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Id;
import com.example.healthcodebe.entity.PlaceVisit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.healthcodebe.entity.PlaceVisitInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:40:52
 */
public interface PlaceVisitService extends IService<PlaceVisit> {
    List<PlaceVisitInfo> getPlaceVisitInfoById(String id);

    void addPlaceVisit(PlaceVisit placeVisit);

    List<Id> getCloseContactById(String id);
}
