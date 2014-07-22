/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Francesco
 */
public class CollectionsTests {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("DDD");
        stringList.add("CCC");
        stringList.add("BBB");
        stringList.add("AAA");
        stringList.add("AAA");
        stringList.add("BBB");
        stringList.add("CCC");
        
        System.out.println("Lista original:");
        stringList.stream().forEach(s -> System.out.println(s));
        System.out.println();
        
        System.out.println("Lista transformada em Set:");
        Set<String> stringSet = stringList.stream().collect(Collectors.toSet());
        stringSet.stream().forEach(s -> System.out.println(s));
        System.out.println();
    }
}
