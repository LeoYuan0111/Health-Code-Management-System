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

/**
 * <p>
 * 
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:55
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("health_code")
@ApiModel(value = "HealthCode对象", description = "")
public class HealthCode {

    @TableId(value = "id_number", type = IdType.AUTO)
    private String idNumber;

    @TableField("color")
    private Integer color;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("qr_code")
    private String qrCode;
}
