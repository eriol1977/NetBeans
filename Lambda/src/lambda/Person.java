/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francesco
 */
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Sex gender;
    int age;

    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void printPerson() {
        System.out.println(name + "(" + age + " - " + gender + ")");
    }
    
    public String getNameAndGender() {
        return name + "(" + gender + ")";
    }
    
    public static int compareByAge(Person a, Person b) {
        return Integer.valueOf(a.age).compareTo(b.age);
    }
    
    static List<Person> initFriends() {
        Person rocco = new Person("Rocco", Person.Sex.MALE, 50);
        Person tony = new Person("Tony", Person.Sex.MALE, 36);
        Person anita = new Person("Anita", Person.Sex.FEMALE, 18);
        Person gianzo = new Person("Gianzo", Person.Sex.MALE, 23);
        Person mari = new Person("Mari", Person.Sex.FEMALE, 25);
        List<Person> friends = new ArrayList<>();
        friends.add(rocco);
        friends.add(tony);
        friends.add(anita);
        friends.add(gianzo);
        friends.add(mari);
        return friends;
    }
}
