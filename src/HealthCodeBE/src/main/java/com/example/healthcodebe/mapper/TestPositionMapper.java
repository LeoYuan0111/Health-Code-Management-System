package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.TestPosition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.healthcodebe.entity.TestPositionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:46:50
 */
@Mapper
public interface TestPositionMapper extends BaseMapper<TestPosition> {
    void addTestPosition(TestPosition testPosition);

    void updateTestPosition(TestPosition testPosition);

    TestPositionInfo getTestPositionById(String placeId);

    List<TestPositionInfo> getTestPositionByCoordinate(@Param("condition") Map<String, Object> condition);

    List<TestPositionInfo> getTestPositionByPage(@Param("condition") Map<String, Object> condition);
}
