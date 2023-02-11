package com.jie.result;

/**
 * 定义返回数据结构
 * @author xlwang
 */
public interface IResult {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 获取消息体
     *
     * @return 消息体
     */
    String getMessage();
}
