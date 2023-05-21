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
 * @since 2023-05-22 00:39:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("vaccine")
@ApiModel(value = "Vaccine对象", description = "")
public class Vaccine {

    @TableId(value = "vacc_id", type = IdType.AUTO)
    private Integer vaccId;

    @TableField("`date`")
    private LocalDateTime date;

    @TableField("provider")
    private String provider;

    @TableField("expiration_date")
    private LocalDateTime expirationDate;
}
