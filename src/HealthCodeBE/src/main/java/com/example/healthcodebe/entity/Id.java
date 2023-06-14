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
 * @since 2023-05-22 00:40:52
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("place_visit")
@ApiModel(value = "PlaceVisit对象", description = "")
public class Id {
    @TableField("id_number")
    private String idNumber;
}
