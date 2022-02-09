package q_18.part_2;


import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.function.Consumer;
        import java.util.function.Function;
        import java.util.function.Predicate;
        import java.util.function.Supplier;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        EmployeeDatabase empFactory = Employee::new;
        Employee emp1 = empFactory.getEmployee("Sankata Gajodhar", 23, "Noida");
        Employee emp2 = empFactory.getEmployee("Birju Yadav", 26, "Delhi");

        List<String> employees =new ArrayList<>();
        employees.add(emp1.toString());
        employees.add(emp2.toString());

//       ===================== Using Consumer interface =============================
        // Referring method to String type Consumer interface
        Consumer<String> printTxt = ConsumerInterface::printMessage;
        printTxt.accept("Hello from consumer");   // Calling Consumer method

        Consumer<List<String>> employeePrint = System.out::println;
        Stream<List<String>> emp_detail = Stream.of((employees));
        emp_detail.forEach(employeePrint);


//      By using default andThen method of Consumer interface
        Consumer<Integer> display = System.out::println;

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list ->
        {
            for (int a = 0; a < list.size(); a++)
                list.set(a, 2 * list.get(a));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer> >
                displayList = list -> list.forEach(x -> System.out.print(x + " "));
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(7);

        // using addThen()
        modify.andThen(displayList).accept(list);


//        =================== Supplier Interface ========================================================
        // This function returns a random value.
        Supplier<Boolean> empty = employees::isEmpty;
        // Print the random value using get()
        printTxt.accept("\nUsing get() method of Supplier Interface : Is employee list empty : "+empty.get());

//       ======================= Using Function Interface ===============================================
        Function<String , Integer> charOfList = String::length;
        // apply the function to get the result
        List<Integer> list1 = employees.stream().map(charOfList).collect(Collectors.toList());
        printTxt.accept("Total no. of characters in given list:"+charOfList.apply(employees.toString()));

//       ============================== Using Predicate Interface =====================================

        Predicate<String> startPredicate = str -> str.startsWith("B");
        Predicate<String> lengthPredicate = str -> str.length() >= 10;
        employees.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);

        // ********************Calling Predicate test() method **********************************
        // Creating predicate
        Predicate<Integer> less_than = age -> (age < 18);

        printTxt.accept("Using Predicate test() method : "+less_than.test(18)+"");

//        *********************** Calling Predicate and() method *******************************
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;
        List<Integer> listArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = listArr.stream()
                .filter(noGreaterThan5.and(noLessThan8))
                .collect(Collectors.toList());

        printTxt.accept("Using Predicate default and() method: "+collect);

    }
}