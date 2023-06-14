package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.PlaceCode;
import com.example.healthcodebe.mapper.PlaceCodeMapper;
import com.example.healthcodebe.service.PlaceCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:40:22
 */
@Service
public class PlaceCodeServiceImpl extends ServiceImpl<PlaceCodeMapper, PlaceCode> implements PlaceCodeService {
    @Resource
    private PlaceCodeMapper placeCodeMapper;

    @Override
    public PlaceCode getPlaceCodeById(String id){
        return placeCodeMapper.getPlaceCodeById(id);
    }

    @Override
    public PlaceCode getNewPlaceCode(@Param("condition") Map<String, Object> condition){
        return placeCodeMapper.getNewPlaceCode(condition);
    }

    @Override
    public void addPlaceCode(PlaceCode placeCode){
        placeCodeMapper.addPlaceCode(placeCode);
    }
}
