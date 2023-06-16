package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.TestPosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.healthcodebe.entity.TestPositionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:46:50
 */
public interface TestPositionService extends IService<TestPosition> {
    void addTestPosition(TestPosition testPosition);

    void updateTestPosition(TestPosition testPosition);

    TestPositionInfo getTestPositionById(String placeId);

    List<TestPositionInfo> getTestPositionByCoordinate(@Param("condition") Map<String, Object> condition);

    List<TestPositionInfo> getTestPositionByPage(@Param("condition") Map<String, Object> condition);
}
