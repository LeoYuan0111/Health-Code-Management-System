package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.Person;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:01
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/user/update_person")
    public boolean update_person(@RequestParam Map<String, Object> condition){
        personService.updatePerson(condition);
        return true;
    }

    @RequestMapping("/admin/user_info")
    public @ResponseBody Object admin_user_info(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        Person person = personService.getPersonById(condition.get("id_number").toString());
        return person;
    }

    @RequestMapping("/admin/user_color_list")
    public @ResponseBody Object admin_user_color_list(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        Map<String, Object> condition_new = new HashMap<>();
        condition_new.put("color", condition.get("color").toString());
        Integer offset = (Integer.valueOf(condition.get("page").toString()) - 1) *
                Integer.valueOf(condition.get("page_size").toString());
        condition_new.put("offset", offset);
        condition_new.put("page_size", Integer.valueOf(condition.get("page_size").toString()));
        List<Person> persons = personService.getPersonByColor(condition_new);
        return persons;
    }
}
