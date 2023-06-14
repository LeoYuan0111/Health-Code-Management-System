package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.TestPosition;
import com.example.healthcodebe.entity.TestPositionInfo;
import com.example.healthcodebe.mapper.TestPositionMapper;
import com.example.healthcodebe.service.TestPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:46:50
 */
@Service
public class TestPositionServiceImpl extends ServiceImpl<TestPositionMapper, TestPosition> implements TestPositionService {
    @Resource
    private TestPositionMapper testPositionMapper;

    @Override
    public void addTestPosition(TestPosition testPosition){
        testPositionMapper.addTestPosition(testPosition);
    }

    @Override
    public void updateTestPosition(TestPosition testPosition){
        testPositionMapper.updateTestPosition(testPosition);
    }

    @Override
    public TestPositionInfo getTestPositionById(String placeId){
        return testPositionMapper.getTestPositionById(placeId);
    }

    @Override
    public List<TestPositionInfo> getTestPositionByCoordinate(@Param("condition") Map<String, Object> condition){
        return testPositionMapper.getTestPositionByCoordinate(condition);
    }
    @Override
    public List<TestPositionInfo> getTestPositionByPage(@Param("condition") Map<String, Object> condition){
        return testPositionMapper.getTestPositionByPage(condition);
    }
}
