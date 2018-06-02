package com.fworldcodez.wzool.constant;

public interface BaseEnum<E extends Enum<?>,T> {
    /**
     * 定义接口的好处:其实主要目的是为了在万能枚举转换器中方便泛型的使用，而且还可以规范枚举类的实现。
     * **/
    public T getValue();
    public String getDisplayName();
}
