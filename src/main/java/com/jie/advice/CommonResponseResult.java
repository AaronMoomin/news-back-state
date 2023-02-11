package com.jie.advice;

import com.alibaba.fastjson.JSON;
import com.jie.result.Result;
import com.jie.validator.ResponseNotIntercept;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 如果引入了swagger或knife4j的文档生成组件，这里需要仅扫描自己项目的包，否则文档无法正常生成
 *
 * @author xlwang55
 * @RestControllerAdvice(basePackages = "com.wxl52d41")
 */
@RestControllerAdvice
public class CommonResponseResult implements ResponseBodyAdvice<Object> {
    /**
     * 支持注解@ResponseNotIntercept，使某些方法无需使用Result封装
     *
     * @param returnType 返回类型
     * @param converterType  选择的转换器类型
     * @return true 时会执行beforeBodyWrite方法，false时直接返回给前端
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (returnType.getDeclaringClass().isAnnotationPresent(ResponseNotIntercept.class)) {
            //若在类中加了@ResponseNotIntercept 则该类中的方法不用做统一的拦截
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(ResponseNotIntercept.class)) {
            //若方法上加了@ResponseNotIntercept 则该方法不用做统一的拦截
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            // 提供一定的灵活度，如果body已经被包装了，就不进行包装
            return body;
        }
        if (body instanceof String) {
            //解决返回值为字符串时，不能正常包装
            return JSON.toJSONString(Result.success(body));
        }
        return Result.success(body);
    }
}
