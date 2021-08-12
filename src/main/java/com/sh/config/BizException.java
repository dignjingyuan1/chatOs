package com.sh.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BizException extends RuntimeException {

    public BizException() {
        super();
    }

    public BizException(String msg) {
        super(msg);
    }
}
