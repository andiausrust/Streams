package andi.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumbers = Arrays.asList(
          "n40", "n36",
          "b12", "b6",
          "g53", "g49", "G45", "G56",
          "i26", "i17", "i29",
          "o71", "O45", "O89"
        );

        List<String> gNumber = new ArrayList<>();

        someBingoNumbers.forEach(
                number -> {
                    if(number.toUpperCase().startsWith("O")){
                        gNumber.add(number);
                        System.out.println(number);
                    }
                }
        );
        gNumber.sort((s1, s2) -> s1.compareTo(s2));
        gNumber.forEach(s -> System.out.println(s));

        System.out.println("###########################");

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("O"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("g53", "g49", "G45", "G56");
        Stream<String> ioNumberStream1 = Stream.of("i26", "i17", "i29", "g53", "g49", "G45", "G56");

        Stream<String> concatString = Stream.concat(ioNumberStream, ioNumberStream1);
        System.out.println(concatString.distinct().count());

        Employee john = new Employee("hohn", 30);
        Employee mon = new Employee("mona", 35);
        Employee lisa = new Employee("lisa", 33);
        Employee hohf = new Employee("hohf", 56);
        Employee cann = new Employee("cann", 30);

        Department humanResources = new Department("Human Resources");
        humanResources.addEmployee(john);
        humanResources.addEmployee(mon);
        humanResources.addEmployee(lisa);


        Department accounting = new Department("accounting");
        accounting.addEmployee(hohf);
        accounting.addEmployee(cann);

        List<Department> departments = Arrays.asList(humanResources, accounting);

        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .forEach(System.out::println);
    }
}
