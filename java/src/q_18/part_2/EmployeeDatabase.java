package q_18.part_2;


@FunctionalInterface
public interface EmployeeDatabase {
    public abstract Employee getEmployee(String name, Integer age, String city);
}