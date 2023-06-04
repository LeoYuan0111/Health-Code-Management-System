package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.TestRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:37:31
 */
@Mapper
public interface TestRecordMapper extends BaseMapper<TestRecord> {

    boolean addSampleInfo(TestRecord testRecord);

    TestRecord getByTubeId(String tube_id);

    boolean updateDetectResult(TestRecord testRecord);
}
