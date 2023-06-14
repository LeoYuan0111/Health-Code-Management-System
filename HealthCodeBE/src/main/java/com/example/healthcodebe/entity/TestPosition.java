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

import java.time.LocalTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:46:50
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("test_position")
@ApiModel(value = "TestPosition对象", description = "")
public class TestPosition {

    @TableId(value = "place_id", type = IdType.AUTO)
    private Integer placeId;

    @TableField("manager_id_number")
    private String managerIdNumber;

    @TableField("start_time")
    private LocalTime startTime;

    @TableField("end_time")
    private LocalTime endTime;

}
