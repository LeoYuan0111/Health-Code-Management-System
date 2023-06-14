package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.Person;
import com.example.healthcodebe.mapper.PersonMapper;
import com.example.healthcodebe.service.PersonService;
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
 * @since 2023-05-22 00:36:01
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
    @Resource
    private PersonMapper personMapper;
    @Override
    public void addPerson(Person person){
        personMapper.addPerson(person);
    }
    @Override
    public void updatePerson(@Param("condition") Map<String, Object> condition){
        personMapper.updatePerson(condition);
    }

    @Override
    public List<Person> getPersonByColor(@Param("condition") Map<String, Object> condition){
        return personMapper.getPersonByColor(condition);
    }
    @Override
    public Person getPersonById(String id){
        return personMapper.getPersonById(id);
    }
}
