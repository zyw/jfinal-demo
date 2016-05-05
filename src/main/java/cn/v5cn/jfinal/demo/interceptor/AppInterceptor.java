package cn.v5cn.jfinal.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by lenovo on 2016/4/29.
 */
public class AppInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        inv.invoke();
    }
}
