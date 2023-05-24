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
 * @since 2023-05-21 23:28:35
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("account")
@ApiModel(value = "Account对象", description = "")
public class Account {

    @TableId(value = "id_number", type = IdType.AUTO)
    private String idNumber;

    @TableField("`password`")
    private String password;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("`admin`")
    private Boolean admin;

    @TableField("sampler")
    private Boolean sampler;

    @TableField("tester")
    private Boolean tester;
}
