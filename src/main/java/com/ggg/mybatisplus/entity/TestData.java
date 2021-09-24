package com.ggg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestData implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Integer testInt;

    private String testStr;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer version;

    private Integer testEnum;

    private Long tenantId;


}
