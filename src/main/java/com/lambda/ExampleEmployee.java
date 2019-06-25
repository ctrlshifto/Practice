package com.lambda;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019-3-17 15:13:50
 * @Modified by:
 */

public class ExampleEmployee {

    private static List<Employee> employeeList = new ArrayList();

    static {
        employeeList.add(new Employee("Steve", 6000, "London"));
        employeeList.add(new Employee("Carrie", 10000, "New York"));
        employeeList.add(new Employee("Peter", 7000, "New York"));
        employeeList.add(new Employee("Alec", 6000, "London"));
        employeeList.add(new Employee("Sarah", 8000, "London"));
        employeeList.add(new Employee("Rebecca", 4000, "New York"));
        employeeList.add(new Employee("Pat", 20000, "New York"));
        employeeList.add(new Employee("Tammy", 9000, "New York"));
        employeeList.add(new Employee("Fred", 15000, "Tokyo"));
    }

    public static Map<String, Integer> generateMapData() {
        Map<String, Integer> items = new HashMap();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        return items;
    }

    public static void main(String[] args) {
        List<Employee> results = employeeList;

        //看看实体类添加进去没
        //employeeList.forEach((employee)-> System.out.println(employee.getName() +"，"+employee.getSalary()+","+employee.getOffice()));

        System.out.println("\n//anyMatch");
        for (Employee employee : employeeList) {
            if (employee.getOffice().equals("London")) {
                System.out.println("true");
            }
        }

        System.out.println("\n//anyMatch 如果有一个match就返回true");
        boolean isMatch = employeeList.stream().anyMatch(employee -> employee.getOffice().equals("London"));
        System.out.println(isMatch);

        System.out.println("\n //如果所有实体类都match则返回true");
        System.out.println(employeeList.stream().allMatch(employee -> employee.getSalary() > 6000));

        System.out.println("\n //找出工资最高");
        Optional<Employee> hightestSalary = employeeList.stream().max(Comparator.comparingInt(Employee::getSalary));
        System.out.println(hightestSalary);

        System.out.println("\n //返回姓名列表");
        List<String> names = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(names);

        System.out.println("\n //------------------------List转换成Map--------------");
        Map<String, Employee> employeeMap = employeeList.stream()
                .collect(Collectors.toMap((Employee::getName), (value -> value)));
        employeeMap.forEach((key, value) -> System.out.println(key + "=" + value));

        System.out.println("\n <name,salary>");
        Map<String, Integer> name2SalaryMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        name2SalaryMap.forEach((key, value) -> System.out.println(key + "=" + value));


        System.out.println("\n //统计办公室是New York的个数");
        long officeCount = employeeList.stream().filter(employee -> "New York".equals(employee.getOffice())).count();
        System.out.println(officeCount);

        System.out.println("\n //List转换为Set");
        Set<String> officeSet = employeeList.stream().map(Employee::getOffice).distinct().collect(Collectors.toSet());
        System.out.println(officeSet);

        System.out.println("\n  //查找办公室地点是New York的员工");
        Optional<Employee> allMatchedEmployees = employeeList.stream()
                .filter(employee -> "New York".equals(employee.getOffice()))
                .findAny();
        System.out.println(allMatchedEmployees);

        System.out.println("\n 按照工资的降序来列出员工信息");
        List<Employee> sortEmployeeList = employeeList.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
        System.out.println(sortEmployeeList);

        System.out.println("\n 按照名字的升序列出员工信息");
        List<Employee> sortEmployeeByName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        System.out.println(sortEmployeeList);
        System.out.println("按照名字的升序列出员工信息:" + sortEmployeeByName);

        System.out.println("\n 获取工资最高的前2条员工信息");
        List<Employee> top2EmployeeList = employeeList.stream()
                .sorted((employee1, employee2) -> Integer.compare(employee2.getSalary(), employee1.getSalary()))
                .limit(2).collect(Collectors.toList());
        System.out.println(top2EmployeeList);

        System.out.println("\n 获取平均工资");
        OptionalDouble averageSalary = employeeList.stream().mapToInt(Employee::getSalary).average();
        System.out.println("平均工资:" + averageSalary);

        System.out.println("\n New York办公室平均工资:");
        OptionalDouble averageSalaryByOffice = employeeList.stream()
                .filter(employee -> "New York".equals(employee.getOffice()))
                .mapToInt(Employee::getSalary)
                .average();
        System.out.println("New York办公室平均工资:" + averageSalaryByOffice);

        System.out.println("\n 打印出名字是Steve的员工信息");
        results.forEach(c -> {
            if (c.getName().equals("Steve")) {
                System.out.println(c);
            }
        });

        System.out.println("\n 找出年薪超过6000的员工");
        results.stream().filter(c -> c.getSalary() >= 6000).forEach(System.out::println);

        System.out.println("\n java8遍历map");
        Map<String, Integer> map_ = generateMapData();
        map_.forEach((key, value) -> System.out.println("key:" + key + "," + "value:" + value));

        System.out.println("\n java8 分组操作");
        Map<String, List<Employee>> groupMap = results.stream().collect(Collectors.groupingBy(Employee::getOffice));
        System.out.println(groupMap);

        System.out.println("\n List转化为Map");
        Map<String, Object> map = results.stream().collect(Collectors.toMap(Employee::getName, Employee::getOffice));
        map.forEach((key, value) -> System.out.println("key:" + key + "," + "value:" + value));

        System.out.println("\n 遍历map");
        //打印出值大于30的map
        Map<String, Integer> resultMap = map_.entrySet().stream()
                .filter(c -> c.getValue() > 30)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        resultMap.forEach((key, value) -> System.out.println(key + "=" + value));

        System.out.println("\n 打印key=D的map");
        Map<String, Integer> mapResults = map_.entrySet().stream()
                .filter(c -> c.getKey().equals("D"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        mapResults.forEach((key, value) -> System.out.println(key + ">>>>" + value));

        System.out.println("\n>>>>>>>Optional>>>>>>>");
        Optional<String> optional = Optional.of("hello");
        System.out.println(optional.isPresent());

    }
}