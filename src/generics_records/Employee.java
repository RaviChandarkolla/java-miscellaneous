package generics_records;

import java.util.Set;

public record Employee<T>(int employeeId, String name, Set<T> majorAchievements, Set<T> minorAchievements) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Employee:");
        sb.append("\n  EmployeeId: ").append(employeeId);
        sb.append("\n  EmployeeName: ").append(name);
        sb.append("\n  majorAchievements: ").append(majorAchievements);
        sb.append("\n  minorAchievements: ").append(minorAchievements);
        return sb.toString();
    }
}
