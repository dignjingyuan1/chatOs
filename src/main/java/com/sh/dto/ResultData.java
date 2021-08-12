package com.sh.dto;

import lombok.Data;

@Data
public class ResultData {

    private Integer code;

    private String msg;

    private Object data;

    public static ResultData success(Object data) {
        return resultData(200, "成功", data);
    }

    public static ResultData fail(String msg) {
        return resultData(500, msg, null);
    }

    private static ResultData resultData(Integer code, String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

}
