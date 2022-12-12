package com.template.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zkl
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test1_crime")
public class TestCrime implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer incidentId;

    private String offenceCode;

    private LocalDateTime dispatchTime;

    private Integer victims;

    private String crimeName1;

    private String crimeName2;

    private String crimeName3;

    private String city;

    private LocalDateTime startDateTime;


}
