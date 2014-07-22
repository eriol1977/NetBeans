/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 *
 * @author Francesco
 */
public class Parallelism {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> friends = Person.initFriends();

        System.out.println("################ Calcula média de idades em paralelo");
        System.out.println(friends
                .parallelStream()
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble());
        System.out.println();

        System.out.println("################ Cria map de pessoas separadas por sexo, em paralelo");
        ConcurrentMap<Person.Sex, List<Person>> porSexo
                = friends
                .parallelStream()
                .collect(
                        Collectors.groupingByConcurrent(Person::getGender));
        System.out.println("Homens");
        porSexo.get(Person.Sex.MALE).stream().forEach(Person::printPerson);
        System.out.println("Mulheres");
        porSexo.get(Person.Sex.FEMALE).stream().forEach(Person::printPerson);
        System.out.println();
    }
}
