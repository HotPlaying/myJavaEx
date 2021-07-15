package com.test.thinkinjava;

import com.test.thinkinjava.typeinfo.pets.Cat;
import com.test.thinkinjava.typeinfo.pets.Pet;

/**
 * @author tangrd
 * @date 2021/6/21 9:49
 * @description
 */

class Automobile {
}

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<>(new Cat());
        h3.get().showType();
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }
}
