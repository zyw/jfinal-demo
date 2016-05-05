package cn.v5cn.jfinal.demo.util;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/5/3.
 */
public class Message<T> implements Serializable {
    private String message;
    private int status;
    private T result;

    public Message(String message, int status, T result) {
        this.message = message;
        this.status = status;
        this.result = result;
    }

    public static <T> Message<T> success(String message, T result){
        return new Message<>(message,1,result);
    }

    public static <T> Message<T> fail(String message, T result){
        return new Message<>(message,0,result);
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
