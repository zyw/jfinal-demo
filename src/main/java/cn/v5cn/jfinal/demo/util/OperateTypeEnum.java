package cn.v5cn.jfinal.demo.util;

/**
 * Created by lenovo on 2016/5/6.
 */
public enum OperateTypeEnum {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete");

    private String operateType;

    OperateTypeEnum(String operateType){
        this.operateType = operateType;
    }

    public String getOperateType(){
        return operateType;
    }
}
