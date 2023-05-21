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
 * @since 2023-05-22 00:36:49
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("vaccination_record")
@ApiModel(value = "VaccinationRecord对象", description = "")
public class VaccinationRecord {

    @TableField("id_number")
    private String idNumber;

    @TableId(value = "vacc_id", type = IdType.AUTO)
    private Integer vaccId;

    @TableField("`date`")
    private LocalDateTime date;

    @TableField("doc_id_number")
    private String docIdNumber;
}
