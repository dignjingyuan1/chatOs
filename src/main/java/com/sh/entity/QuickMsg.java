package com.sh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sh.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tiger
 * @since 2021-06-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_quick_msg")
public class QuickMsg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 常用语内容
     */
    private String text;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 常用语类型
     */
    private Integer type;


}
