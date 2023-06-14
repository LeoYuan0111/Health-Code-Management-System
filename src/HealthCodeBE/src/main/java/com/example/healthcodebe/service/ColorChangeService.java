package com.example.healthcodebe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.healthcodebe.entity.ColorChange;
import com.example.healthcodebe.entity.HealthCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ColorChangeService extends IService<ColorChange> {
    List<ColorChange> getColorChangeById(String id);

    void addColorChange(ColorChange colorChange);
}