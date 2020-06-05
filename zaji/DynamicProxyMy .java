package com.itheima.demo.proxysdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;
//jdk的动态代理,还有一种cglib的动态代理
public class DynamicProxyMy {
    /**
     * 使用Proxy类的newinstance()方法生成的代理对象iLawSuitProxy,
     * iLawSuitProxy.submit("piaochang")操作,系统就会将此方法发给invoke();
     * 其中的iLawSuitProxy对象的类是系统帮忙动态生产的,其实现了我们的业务接口ILawSuit
     * @param args
     */
    public static void main(String[] args) {
        ILawSuit iLawSuitProxy = (ILawSuit) ProxyFactory.getDynProxy(new ZhangSan());
        iLawSuitProxy.defend();
        iLawSuitProxy.submit("piaochang");
    }

}
class ZhangSan implements ILawSuit{

    @Override
    public void submit(String proof) {
        System.out.println(String.format("老板跑路,证据如下:%s",proof));
    }

    @Override
    public void defend() {
        System.out.println("zhangsan....huanqian");
    }
}
class DynProxyLawyer implements InvocationHandler{
    private Object object;//被代理的对象
    public DynProxyLawyer(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("案件进展:"+method.getName());
        Object result = method.invoke(object, args);
        return result;
    }
}
class ProxyFactory{
    public static Object getDynProxy(Object target){
        InvocationHandler invocationHandler = new DynProxyLawyer(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), invocationHandler);
    }
}
