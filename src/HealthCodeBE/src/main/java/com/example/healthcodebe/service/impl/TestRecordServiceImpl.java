package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.TestRecord;
import com.example.healthcodebe.mapper.TestRecordMapper;
import com.example.healthcodebe.service.TestRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:37:31
 */
@Service
public class TestRecordServiceImpl extends ServiceImpl<TestRecordMapper, TestRecord> implements TestRecordService {
    @Resource
    private TestRecordMapper testRecordMapper;
    @Override
    public boolean addSampleInfo(TestRecord testRecord) {
        return testRecordMapper.addSampleInfo(testRecord);
    }

    @Override
    public TestRecord getByTubeId(String tube_id) {
        return testRecordMapper.getByTubeId(tube_id);
    }

    @Override
    public boolean updateDetectResult(TestRecord testRecord) {
        return testRecordMapper.updateDetectResult(testRecord);
    }

    @Override
    public List<TestRecord> getDetectResults(String id_number) {
        return testRecordMapper.getById(id_number);
    }
}
