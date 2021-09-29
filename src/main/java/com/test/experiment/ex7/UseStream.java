package com.test.experiment.ex7;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author trd
 * @since 2021/9/2 14:41
 */
public class UseStream {
    enum Gender {
        male, female
    }

    //    public static void main(String[] args) {
//        Stream<User> stream = User.getUserList().stream();
//        // 过滤出名字包含L的
//        Stream<User> nameStream = stream.filter(user -> user.getName().contains("L"));
//
//    }
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(Gender.male, 180, 70.4, "1987"));
        personList.add(new Person(Gender.male, 167, 64.6, "2001"));
        personList.add(new Person(Gender.female, 165, 49.0, "1977"));
        personList.add(new Person(Gender.male, 172, 69.1, "1999"));
        personList.add(new Person(Gender.female, 159, 45.5, "1980"));

        Stream<Person> stream = personList.stream();

        Stream<Person> hStream = stream.filter(person -> person.getHeight() > 170);
        Stream<Double> wStream = hStream.map(Person::getWeight);
        List<Person> hList = hStream.collect(Collectors.toList());

        List<Double> wList = wStream.collect(Collectors.toList());

        System.out.println();
    }
}

@Data
class Person {


    private UseStream.Gender gender;
    private Integer height;
    private Double weight;
    private String birthday;

    public Person(UseStream.Gender gender, Integer height, Double weight, String birthday) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
    }
}


