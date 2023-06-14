package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.ColorChange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:55
 */
@Mapper
public interface ColorChangeMapper extends BaseMapper<ColorChange> {
    List<ColorChange> getColorChangeById(String id);

    void addColorChange(ColorChange colorChange);
}