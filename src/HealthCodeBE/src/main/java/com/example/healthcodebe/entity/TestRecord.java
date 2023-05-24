package com.example.healthcodebe.entity;

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

/**
 * <p>
 * 
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:37:31
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("test_record")
@ApiModel(value = "TestRecord对象", description = "")
public class TestRecord {

    @TableField("id_number")
    private String idNumber;

    @TableId(value = "tube_id", type = IdType.AUTO)
    private Integer tubeId;

    @TableField("`date`")
    private LocalDateTime date;

    @TableField("sampler_id_number")
    private String samplerIdNumber;

    @TableField("tester_id_number")
    private String testerIdNumber;

    @TableField("result")
    private Boolean result;
}
