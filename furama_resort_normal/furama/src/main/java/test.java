import java.util.Random;

public class test {
    public static void main(String[] args) {
        Random rand = new Random();
        int ranNum = rand.nextInt(65)+1;
        System.err.println(ranNum);
    }
}
