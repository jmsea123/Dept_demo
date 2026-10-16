package com.hyz.dept.common;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    /** 业务状态码 */
    private Integer code;
    /** 提示消息 */
    private String msg;
    /** 返回数据 */
    private T data;
    /** 成功标记 */
    private Boolean success;


    // ====================== 静态快捷方法（Controller直接用，兼容旧业务） ======================

    /**
     * 成功，带数据，默认消息
     */
    public static <T> R<T> success(T data) {
        return R.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .msg(ResultEnum.SUCCESS.getMsg())
                .data(data)
                .success(true)
                .build();
    }

    /**
     * 成功，无数据
     */
    public static <T> R<T> success() {
        return success(null);
    }

    /**
     * 成功：data + 自定义msg
     */
    public static <T> R<T> success(T data, String msg) {
        return R.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .msg(msg)
                .data(data)
                .success(true)
                .build();
    }

    /**
     * 成功，仅自定义消息（删除/更新接口，data=null）
     */
    public static <T> R<T> successMsg(String msg) {
        return R.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .msg(msg)
                .data(null)
                .success(true)
                .build();
    }

    /**
     * 使用枚举构建返回结果
     */
    public static <T> R<T> ofEnum(ResultEnum resultEnum, T data) {
        return R.<T>builder()
                .code(resultEnum.getCode())
                .msg(resultEnum.getMsg())
                .data(data)
                .success(resultEnum == ResultEnum.SUCCESS)
                .build();
    }

    // -------- 失败快捷方法 --------

    public static <T> R<T> fail(Integer code, String msg) {
        return R.<T>builder()
                .code(code)
                .msg(msg)
                .data(null)
                .success(false)
                .build();
    }

    public static <T> R<T> fail(String msg) {
        return fail(ResultEnum.FAIL.getCode(), msg);
    }

    public static <T> R<T> paramFail(String msg) {
        return fail(ResultEnum.PARAM_ERROR.getCode(), msg);
    }

    public static <T> R<T> notFound(String msg) {
        return fail(ResultEnum.NOT_FOUND.getCode(), msg);
    }

    /**
     * 判断是否成功
     */
    public boolean isSuccess() {
        return ResultEnum.SUCCESS.getCode().equals(this.code);
    }
}

