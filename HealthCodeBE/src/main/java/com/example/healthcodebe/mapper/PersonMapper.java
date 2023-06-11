package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:01
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
