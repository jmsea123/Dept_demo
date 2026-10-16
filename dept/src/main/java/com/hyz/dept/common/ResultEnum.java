package com.hyz.dept.common;

public enum ResultEnum {
    SUCCESS(200, "操作成功"),
    FAIL(500, "服务器业务异常"),
    PARAM_ERROR(400, "参数校验失败"),
    NOT_FOUND(404, "数据不存在"),
    UNAUTH(401, "未登录或权限不足");

    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
