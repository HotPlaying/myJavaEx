package com.test.thinkinjava.util;

import com.test.thinkinjava.coffee.Coffee;
import com.test.thinkinjava.coffee.CoffeeGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generators {
    public static <T> Collection<T>
    fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.println(c);
        }

        List<String> strings = makeList("a", "b", "c");
        System.out.println(strings);
    }
}
