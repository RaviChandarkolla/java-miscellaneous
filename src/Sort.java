import java.util.*;

class User {
    public String name;
    public String grade;

    public User(String name, String grade) {
        super();
        this.name = name;
        this.grade = grade;
    }
}

public class Sort {

    public static void main(String[] args) {
        User user1 = new User("Aima", "A");
        User user2 = new User("Arjun", "A+");
        User user3 = new User("Iram", "B+");
        User user4 = new User("Zia", "C");
        User user5 = new User("Karan", "A");
        User user6 = new User("Mithum", "B");
        User user7 = new User("Ankur", "B+");

        Map<String, Integer> map = new HashMap<>();

        map.put("A+", 6);
        map.put("A", 5);
        map.put("B+", 4);
        map.put("B", 3);
        map.put("C+", 2);
        map.put("C", 1);

        List<User> userList = new LinkedList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);

//        Collections.sort(userList, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return map.get(o2.grade) - map.get(o1.grade);
//            }
//        });

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).name + "||" + userList.get(i).grade);
        }

    }
}
