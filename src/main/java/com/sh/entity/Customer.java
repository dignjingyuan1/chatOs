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
@TableName("t_customer")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String name;

    private String openId;

    /**
     * 头像
     */
    private String headerImg;

    /**
     * 最后登陆时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 登陆状态
     */
    private Integer status;

    /**
     * 对应客服id
     */
    private String parentUserId;

    /**
     * 是否是黑名单
     */
    private Integer isBlacklist;


}
