package trickyquestions;

public class TryCatch1 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }
}
