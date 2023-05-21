package com.example.healthcodebe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("person")
@ApiModel(value = "Person对象", description = "")
public class Person {

    @TableId(value = "id_number", type = IdType.AUTO)
    private String idNumber;

    @TableField("real_name")
    private String realName;

    @TableField("email")
    private String email;

    @TableField("age")
    private Integer age;

    @TableField("addr")
    private String addr;
}
