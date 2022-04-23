import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        Population pop = new Population(100, 0.05);
//        int gen = 0;
//        while (pop.mostFit.fitness() != 0) {
//            gen++;
//            pop.day();
//            System.out.println(gen + ": " + pop.mostFit.toString());
//        }
//        System.out.println(pop.mostFit);

        System.out.println("TESTING CROSSOVER, CROSSING 'WATAME' with 'TSUNOMAKI'");
        crossoverTest();
        System.out.println("TESTING FITNESS ALGORITHM, TARGET: TSUNOMAKI WATAME");
        fitnessTest("WATAMELON");
        fitnessTest("A");
        fitnessTest("TSUNOMAKI WATIME");
        fitnessTest("TSUNOMAKI WATAME");
    }
    static void fitnessTest(String value) {
        int n = value.length();
        String target = "TSUNOMAKI WATAME";
        int m = target.length();
        int[][] D = new int[n+1][m+1];
        for (int row = 0; row < n+1; row++) {
            D[row][0] = row;
            for (int col = 0; col < m+1; col++) {
                D[0][col] = col;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (value.charAt(i-1) == target.charAt(j-1)) {
                    D[i][j] = D[i-1][j-1];
                }
                else {
                    int min = Math.min(D[i-1][j] + 1, D[i][j-1] + 1);
                    D[i][j] = Math.min(min, D[i-1][j-1] + 1);
                }
            }
        }
        int f = D[n][m] + (Math.abs(n-m) + 1)/2;
        System.out.println("Fitness of "+ value + ": " + f);
    }
    /*
    Slightly edited code from Genome's crossover for testing.
     */
    static void crossoverTest() {
        List<Character> other = List.of('W','A','T','A','M','E');
        Random random = new Random();
        List<Character> cross = new LinkedList<>();
        List<Character> value = List.of('T','S','U','N','O','M','A','K','I');
        int index = Math.max(value.size(), other.size());
        boolean empty = false;
        for (int i = 0; i < index && !empty; i++) {
            int rand = random.nextInt(2);
            if (rand == 1) {
                if (i < value.size()) {
                    cross.add(value.get(i));
                } else {
                    empty = true;
                }
            } else {
                if (i < other.size()) {
                    cross.add(other.get(i));
                } else {
                    empty = true;
                }
            }
        }
        for (Character c : cross) {
            System.out.print(c);
        }
        System.out.println();
    }
}
