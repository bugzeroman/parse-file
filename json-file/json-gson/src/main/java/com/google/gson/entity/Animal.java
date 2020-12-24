package com.google.gson.entity;

/**
 * 复杂类型进阶，泛型使用的示例对象
 *
 * @param <T>
 */
public class Animal<T> {
    T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public String toString() {
        return "Animal [value=" + value + "]";
    }

    // public static void main(String[] args) {
    // Gson gson = new Gson();
    // Foo<Bar> foo = new Foo<Bar>();
    // Bar bar = new Bar();
    // foo.set(bar);
    //
    // String json = gson.toJson(foo);
    // }
}
