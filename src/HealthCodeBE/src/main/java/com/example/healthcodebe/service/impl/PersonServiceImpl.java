package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.Person;
import com.example.healthcodebe.mapper.PersonMapper;
import com.example.healthcodebe.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
