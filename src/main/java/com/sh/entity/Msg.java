package com.sh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("t_msg")
public class Msg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 客户消息
     */
    private String customerId;

    /**
     * 客服消息
     */
    private String userId;

    /**
     * 接收状态
     */
    private Integer status;

    /**
     * 消息接收时间
     */
    private LocalDateTime receiveTime;


}
