package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.Id;
import com.example.healthcodebe.entity.PlaceVisit;
import com.example.healthcodebe.entity.PlaceVisitInfo;
import com.example.healthcodebe.mapper.PlaceVisitMapper;
import com.example.healthcodebe.service.PlaceVisitService;
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
 * @since 2023-05-22 00:40:52
 */
@Service
public class PlaceVisitServiceImpl extends ServiceImpl<PlaceVisitMapper, PlaceVisit> implements PlaceVisitService {
    @Resource
    private PlaceVisitMapper placeVisitMapper;

    @Override
    public List<PlaceVisitInfo> getPlaceVisitInfoById(String id){
        return placeVisitMapper.getPlaceVisitInfoById(id);
    }

    @Override
    public void addPlaceVisit(PlaceVisit placeVisit){
        placeVisitMapper.addPlaceVisit(placeVisit);
    }

    @Override
    public List<Id> getCloseContactById(String id){
        return placeVisitMapper.getCloseContactById(id);
    }
}
