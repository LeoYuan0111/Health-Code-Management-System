package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.TestRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:37:31
 */
public interface TestRecordService extends IService<TestRecord> {

    boolean addSampleInfo(TestRecord testRecord);

    TestRecord getByTubeId(String tube_id);

    boolean updateDetectResult(TestRecord testRecord);
}
