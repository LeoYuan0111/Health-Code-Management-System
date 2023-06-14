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
 * @since 2023-05-22 00:40:22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("place_code")
@ApiModel(value = "PlaceCode对象", description = "")
public class PlaceCode {

    @TableId(value = "place_id", type = IdType.AUTO)
    private Integer placeId;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("longitude")
    private double longitude;

    @TableField("latitude")
    private double latitude;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("county")
    private String county;

    @TableField("village")
    private String village;

    @TableField("detail_addr")
    private String detailAddr;
}
