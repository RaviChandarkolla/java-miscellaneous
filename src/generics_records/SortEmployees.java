package generics_records;


import java.util.*;

public class SortEmployees<T> {
    // T must be declared somewhere
    List<Set<T>> majorAchievements = new ArrayList<>();
    List<Set<T>> minorAchievements = new ArrayList<>();

    public static void main(String[] args) {

        SortEmployees<Integer> sortEmp = new SortEmployees<>();
        sortEmp.majorAchievements.add(Set.of(1));
        sortEmp.majorAchievements.add(Set.of(2));
        sortEmp.majorAchievements.add(Set.of(3));
        sortEmp.minorAchievements.add(Set.of(1));
        sortEmp.minorAchievements.add(Set.of(2));
        sortEmp.minorAchievements.add(Set.of(3));

        Employee<Integer> empRecord1 = new Employee<>(1, "Ravi", add(sortEmp.majorAchievements.get(0), sortEmp.minorAchievements.get(0)), add(null, null));
        Employee<Integer> empRecord2 = new Employee<>(2, "Chandar", add(null, null), add(sortEmp.majorAchievements.get(1), sortEmp.minorAchievements.get(1)));
        Employee<Integer> empRecord3 = new Employee<>(3, "Kolla", add(sortEmp.majorAchievements.get(2), sortEmp.minorAchievements.get(2)), add(sortEmp.majorAchievements.get(2), sortEmp.minorAchievements.get(2)));

        List<Employee<Integer>> list = new ArrayList<>(List.of(empRecord1, empRecord2, empRecord3));
        Comparator<Employee<Integer>> comparator = Comparator.comparingInt((Employee<Integer> e) -> e.majorAchievements().size()+e.minorAchievements().size()).reversed().thenComparingInt((Employee<Integer> e) -> e.majorAchievements().size()).reversed().thenComparingInt((Employee<Integer> e) -> e.minorAchievements().size()).reversed().thenComparing(Employee::employeeId);
//        list.sort(Comparator.comparingInt((Employee<Integer> e) -> e.majorAchievements().size() + e.minorAchievements().size()).reversed());
        list.sort(comparator);
        System.out.println(list);
    }


    public static <T> Set<T> add(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>();

        if (set1 != null) {
            set.addAll(set1);
        }

        if (set2 != null) {
            set.addAll(set2);
        }

        return set;
    }
}
