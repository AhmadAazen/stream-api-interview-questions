import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"ghjk",10,90.0,"HR");
        Employee e2 = new Employee(2,"hhj",20, 390000.0,"HR");
        Employee e3 = new Employee(3,"jhj",30,659000.0,"Finance");
        Employee e4 = new Employee(4,"gh",40,239000.0,"Marketing");
        Employee e5 = new Employee(5,"ghj",24,490.0,"Development");
        Employee e6 = new Employee(6,"gj",26,900.0,"Development");
        Employee e7 = new Employee(7,"hj",35,920000.67,"Marketing");
        Employee e8 = new Employee(8,"g",25,910000.89,"Marketing");
        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8);

        //Task: Filter by age > 25, transform to Name, collect to List.
        List<String> names = employees.stream().filter(e -> e.getAge() > 25)
                .map(Employee::getName)
                .toList();

        names.forEach(System.out::println);

        //Convert a list of Strings to uppercase and join them with a comma.
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        String result = fruits.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(result);

        //Task: Return a Map<String, List<Employee>> where key is Department name.
        Map<String, List<Employee>> groupByDep = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupByDep.entrySet().forEach(System.out::println);

        //Count the number of employees in each department #Task: Return Map<String, Long>.
        Map<String, Long> countByDep = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        countByDep.entrySet().forEach(System.out::println);

        //Partition a list of numbers into "Even" and "Odd".
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 30, 45, 50, 65);
        Map<Boolean, List<Integer>> partitionedList = numList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        partitionedList.entrySet().forEach(System.out::println);


    }
}