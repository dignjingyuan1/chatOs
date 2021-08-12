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
@TableName("t_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String phone;

    private String passWord;

    private String headerImg;

    /**
     * 二维码
     */
    private String qrCode;


}
