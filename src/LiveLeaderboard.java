import java.util.*;

public class LiveLeaderboard {

    public LiveLeaderboard() { }

    public static Map<Integer, Integer> map=  new HashMap<>();

    public static List<Integer> list = new LinkedList<>();

    public void updateScore(int playerId, int delta) {
        if (map.containsKey(playerId)) {
            int currVal = map.get(playerId);
            map.put(playerId, currVal+ delta);
        } else {
            map.put(playerId, delta);
        }
        updateList(playerId);
    }

    public static void updateList(int playerId) {
        int index = -1;
        for (int i =0; i < list.size(); i++) {
            if(list.get(i) == playerId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            list.remove(index);
        }

        int i = 0;
        for (;i < list.size(); i ++) {
            int currId = list.get(i);
            int currScore = map.get(currId);
            int playerScore = map.get(playerId);
            if (playerScore > currScore) {
                list.add(i, playerId);
                break;
            }
        }
        if (i == list.size()) {
            list.add(playerId);
        }
    }

    public int getRank(int playerId) {
        for (int i =0;i < list.size(); i++) {
            if (list.get(i) == playerId) {
                return i + 1;
            }
        }

        return -1;
    }

    public List<Integer> topK(int k) { return new ArrayList<>(); }

    public static void main(String[] args) {
        LiveLeaderboard lb = new LiveLeaderboard();
        lb.updateScore(101, 50);
        lb.updateScore(102, 70);
        lb.updateScore(103, 40);
        lb.updateScore(101, 30);

        System.out.println("Rank of 101 = " + lb.getRank(101));
        System.out.println("Rank of 102 = " + lb.getRank(102));
        System.out.println("Rank of 103 = " + lb.getRank(103));

        System.out.println("Top 2 = " + lb.topK(2));
    }
}