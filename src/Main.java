import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
//    crossoverTest();
        Population pop = new Population(100, 0.05);
        while (pop.mostFit.fitness() != 0) {
            System.out.println(pop.mostFit.toString());
            pop.day();
        }
        System.out.println(pop.mostFit);

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
    }
}
