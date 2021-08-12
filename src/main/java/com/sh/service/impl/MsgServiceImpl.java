package com.sh.service.impl;

import com.sh.entity.Msg;
import com.sh.mapper.MsgMapper;
import com.sh.service.IMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiger
 * @since 2021-06-14
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements IMsgService {

}
