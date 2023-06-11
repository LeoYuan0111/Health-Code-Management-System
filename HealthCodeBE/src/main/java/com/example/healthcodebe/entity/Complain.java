package com.example.healthcodebe.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
@Getter
@Setter
@Accessors(chain = true)
@TableName("complain")
@ApiModel(value = "Complain对象", description = "")
public class Complain {

    @TableId(value = "complain_id", type = IdType.AUTO)
    private String complainId;

    @TableField(value = "id_number")
    private String idNumber;

    @TableField(value = "time")
    private LocalDateTime time;

    @TableField("content")
    private String content;

    @TableField("result")
    private Integer result;

    @TableField("reply")
    private String reply;

    @TableField("withdraw")
    private Integer withdraw;
}