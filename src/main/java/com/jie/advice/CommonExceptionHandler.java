package com.jie.advice;

import com.jie.result.Result;
import com.jie.result.ResultEnum;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

/**
 * 统一拦截异常
 *
 * @author xlwang
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    /**
     * 参数缺失异常
     * 说明：参数为必填时，若入参中无此参数则会报MissingServletRequestParameterException
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error(ex.getMessage(), ex);
        return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), ex.getMessage());
    }

    /**
     * 参数值类型异常
     * 说明: 定义Integer类型，输入的为String，会出现 MethodArgumentTypeMismatchException异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error(ex.getMessage(), ex);
        String message = "参数:" + ex.getName() + " 类型错误";
        return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), message);
    }

    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f == null ? "null" : f.getField() + ": " + f.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), msg);
    }

    @ExceptionHandler(BindException.class)
    public Result<?> handleBindException(BindException ex) {
        log.error(ex.getMessage(), ex);
        return Result.failed(HttpStatus.BAD_REQUEST.value(),
                ex.getAllErrors().stream()
                        .map(ObjectError::getDefaultMessage)
                        .collect(Collectors.joining("; "))
        );
    }



    /**
     * 顶级异常捕获并统一处理，当其他异常无法处理时候选择使用
     */
    @ExceptionHandler({Exception.class})
    public Result<?> handle(Exception ex) {
        log.error(ex.getMessage(), ex);
        return Result.failed(ResultEnum.COMMON_FAILED);
    }

    /**
     * 处理已知的系统异常
     */
    @ExceptionHandler({ServletException.class})
    public Result<?> handle1(Exception ex) {
        log.error(ex.getMessage(), ex);
        return Result.failed(ex.getMessage());
    }

}
