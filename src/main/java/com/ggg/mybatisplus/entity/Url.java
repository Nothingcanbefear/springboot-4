package com.ggg.mybatisplus.entity;

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
public class Url implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private String url;

    private LocalDateTime createDate;


}
