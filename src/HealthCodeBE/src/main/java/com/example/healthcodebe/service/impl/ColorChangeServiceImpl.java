package com.example.healthcodebe.service.impl;
import com.example.healthcodebe.entity.ColorChange;
import com.example.healthcodebe.entity.HealthCode;
import com.example.healthcodebe.mapper.AccountMapper;
import com.example.healthcodebe.mapper.ColorChangeMapper;
import com.example.healthcodebe.mapper.HealthCodeMapper;
import com.example.healthcodebe.service.ColorChangeService;
import com.example.healthcodebe.service.HealthCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ColorChangeServiceImpl extends ServiceImpl<ColorChangeMapper, ColorChange> implements ColorChangeService {
    @Resource
    ColorChangeMapper colorChangeMapper;

    @Override
    public List<ColorChange> getColorChangeById(String id){
        return colorChangeMapper.getColorChangeById(id);
    }

    @Override
    public void addColorChange(ColorChange colorChange){
        colorChangeMapper.addColorChange(colorChange);
    }
}