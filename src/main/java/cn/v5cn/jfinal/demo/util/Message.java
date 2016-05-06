package cn.v5cn.jfinal.demo.util;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/5/3.
 */
public class Message<T> implements Serializable {
    private String message;
    private int status;
    private OperateTypeEnum operateType;
    private T result;

    public Message(String message, int status, T result,OperateTypeEnum operateType) {
        this.message = message;
        this.status = status;
        this.result = result;
        this.operateType = operateType;
    }

    public static <T> Message<T> success(String message, T result,OperateTypeEnum operateTypeEnum){
        return new Message<>(message,1,result,operateTypeEnum);
    }

    public static <T> Message<T> fail(String message, T result,OperateTypeEnum operateTypeEnum){
        return new Message<>(message,0,result,operateTypeEnum);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OperateTypeEnum getOperateType() {
        return operateType;
    }

    public void setOperateType(OperateTypeEnum operateType) {
        this.operateType = operateType;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
