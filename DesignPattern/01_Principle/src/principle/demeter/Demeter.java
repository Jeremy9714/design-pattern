package principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则
 *
 * @author Chenyang
 * @create 2021-07-16-10:43
 */
public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

class Employee {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class CollegeEmployee {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class CollegeManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            Employee employee = new Employee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }

    //输出员工
    public void printAllEmployee() {
        List<Employee> list = getAllEmployee();
        for (Employee ele : list) {
            System.out.println(ele.getId());
        }
    }
}

class SchoolManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId(i);
            list.add(collegeEmployee);
        }
        return list;
    }

    public void printAllEmployee(CollegeManager manager) {
        //将输出Employee的方法·封装到CollegeManager中
        manager.printAllEmployee();

        List<CollegeEmployee> list = getAllEmployee();
        for (CollegeEmployee ele : list) {
            System.out.println(ele.getId());
        }
    }
}