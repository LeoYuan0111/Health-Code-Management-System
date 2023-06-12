package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:01
 */
public interface PersonService extends IService<Person> {
    void addPerson(Person person);
    void updatePerson(@Param("condition") Map<String, Object> condition);
    List<Person> getPersonByColor(@Param("condition") Map<String, Object> condition);
    Person getPersonById(String id);
}
