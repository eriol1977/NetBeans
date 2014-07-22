/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Francesco
 */
public class Lambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> friends = Person.initFriends();

        System.out.println("################ Imprime todos");
        printPersons(friends);
        System.out.println();

        System.out.println("################ Imprime com Predicate");
        printPersonsWithPredicate(friends, p -> p.getGender().equals(Person.Sex.FEMALE));
        System.out.println();

        System.out.println("################ Imprime com Predicate e Consumer");
        printPersonsWithPredicateAndConsumer(friends, p -> p.getGender().equals(Person.Sex.MALE), p -> p.printPerson());
        System.out.println();

        System.out.println("################ Imprime com Predicate, Consumer e Function");
        printPersonsWithPredicateConsumerAndFunction(friends, p -> p.getGender().equals(Person.Sex.MALE), name -> System.out.println(name), p -> p.getName());
        System.out.println();
        
        System.out.println("################ Imprime outra coisa com Predicate, Consumer e Function");
        printPersonsWithPredicateConsumerAndFunction(friends, p -> p.getAge() <= 25, text -> System.out.println(text + " OK!"), p -> p.getNameAndGender());
        System.out.println();
        
        System.out.println("################ Imprime usando Aggregate Operations");
        friends.stream().filter(p -> p.getAge() <= 25).map(p -> p.getNameAndGender()).forEach(text -> System.out.println(text + " YES!"));
        System.out.println();
        
        System.out.println("################ Imprime ordenados por idade");
        friends.stream().sorted(Person::compareByAge).forEach(p -> p.printPerson());
        System.out.println();
        
        System.out.println("################ Imprime a média de idade dos homens da lista");
        System.out.println("Média = " + friends.stream().filter(p -> p.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).average().getAsDouble());
        System.out.println();
        
        System.out.println("################ Imprime a soma das idade das mulheres da lista");
        System.out.println("Soma = " + friends.stream().filter(p -> p.getGender() == Person.Sex.FEMALE).mapToInt(Person::getAge).sum());
        System.out.println();
        
        System.out.println("################ Conta as pessoas com idade >= 25");
        System.out.println("Número = " + friends.stream().filter(p -> p.getAge() >= 25).count());
        System.out.println();
        
        List<Integer> numeros = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        System.out.println("################ Imprime a soma dos quadrados dos números da lista");
        System.out.println("Resultado = " + numeros.stream().reduce(0, (a,b)-> (a + b*b)));
        System.out.println();
        
        System.out.println("################ Cria uma lista de homens com mais de 30 anos");
        List<Person> selected = friends.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() > 30).collect(Collectors.toList());
        selected.stream().forEach(p -> p.printPerson());
        System.out.println();
        
        System.out.println("################ Cria map de pessoas separadas por sexo");
        Map<Person.Sex, List<Person>> porSexo = friends.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println("Homens");
        porSexo.get(Person.Sex.MALE).stream().forEach(Person::printPerson);
        System.out.println("Mulheres");
        porSexo.get(Person.Sex.FEMALE).stream().forEach(Person::printPerson);
        System.out.println();
        
        System.out.println("################ Cria map com os nomes das pessoas separadas por sexo");
        Map<Person.Sex, List<String>> nomesPorSexo = friends.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println("Homens: " + nomesPorSexo.get(Person.Sex.MALE).stream().collect(Collectors.joining(" - ")));
        System.out.println("Mulheres: " + nomesPorSexo.get(Person.Sex.FEMALE).stream().collect(Collectors.joining(" - ")));
        System.out.println();
        
        System.out.println("################ Cria map com a idade média das pessoas separadas por sexo");
        Map<Person.Sex, Double> mediaPorSexo = friends.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.averagingInt(Person::getAge)));
        System.out.println("Homens: " + mediaPorSexo.get(Person.Sex.MALE));
        System.out.println("Mulheres: " + mediaPorSexo.get(Person.Sex.FEMALE));
        System.out.println();
        
        System.out.println("################ Cria map com a soma das idades das pessoas separadas por sexo");
        Map<Person.Sex, Integer> somaPorSexo = friends.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.reducing(0, Person::getAge, Integer::sum)));
        System.out.println("Homens: " + somaPorSexo.get(Person.Sex.MALE));
        System.out.println("Mulheres: " + somaPorSexo.get(Person.Sex.FEMALE));
        System.out.println();
    }

    public static void printPersons(
            List<Person> roster) {
        roster.stream().forEach((p) -> {
            p.printPerson();
        });
    }

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        roster.stream().filter(p -> tester.test(p)).forEach(p -> {
            p.printPerson();
        });
    }

    public static void printPersonsWithPredicateAndConsumer(
            List<Person> roster, Predicate<Person> tester, Consumer<Person> consumer) {
        roster.stream().filter(p -> tester.test(p)).forEach(p -> {
            consumer.accept(p);
        });
    }

    public static void printPersonsWithPredicateConsumerAndFunction(
            List<Person> roster, Predicate<Person> tester, Consumer<String> consumer, Function<Person, String> mapper) {
        roster.stream().filter(p -> tester.test(p)).forEach(p -> {
            String name = mapper.apply(p);
            consumer.accept(name);
        });
    }
}
