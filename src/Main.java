import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        runTests();

        long start = System.currentTimeMillis();

        Population pop = new Population(100, 0.05);
        int gen = 0;
        while (pop.mostFit.fitness() != 0) {
            gen++;
            pop.day();
            System.out.println("Gen " + gen + ": " + pop.mostFit.toString());
        }
        long end = System.currentTimeMillis();

        System.out.println("Generations: " + gen);
        System.out.println("Runtime: " + (end - start) + " milliseconds.");
    }
    static void runTests() {
        System.out.println("Running tests...");
        System.out.println("Testing crossover, Crossing 'XXXXXX' with 'OOOOOO'");
        for (int i = 0; i < 5; i++) {
            crossoverTest();
        }
        System.out.println();
        System.out.println("Testing Fitness algorithm...");
        fitnessTest();
        System.out.println();
        mutateTest();
        populationTest();
    }

    static void populationTest() {
        System.out.println("Testing Day()...");
        List<Genome> test = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            if (i < 3) test.add(new Genome("PAULO xxxxxx xxxxxxxxx xxxxxxxx xxxxxxx"));
            else if (i < 7) test.add(new Genome("TEST TEST TEST"));
            else test.add(new Genome("xxxxx xxxxxx xxxxxxxxx xxxxxxxx xxxxxxx"));
        }
        Population testPop = new Population(test);
        System.out.println(testPop.mostFit);
        System.out.println("Day passes...");
        testPop.day();
        System.out.println(testPop.mostFit);
        for (int i = 0; i < 4; i++) {
            System.out.println("Day passes...");
            testPop.day();
            System.out.println(testPop.mostFit);
        }
    }

    static void mutateTest() {
        System.out.println("Testing mutations, with \"TESTING MUTATIONS\"");
        for (int i = 0; i < 5; i++) {
            Genome test = new Genome("TESTING MUTATIONS");
            test.mutate();
            System.out.println(test);
        }
    }
    static void fitnessTest() {
        Genome testA = new Genome("A");
        System.out.println("Fitness of A: " + testA.fitness());
        Genome testB = new Genome("PAULO SERGIO LICCIARDI MESSEDER BARRETO");
        System.out.println("Fitness of target: " + testB.fitness());
        Genome testC = new Genome("xxxxx xxxxxx xxxxxxxxx xxxxxxxx xxxxxxx");
        System.out.println("Fitness of same length as target but wrong letters:" + testC.fitness());
    }
    static void crossoverTest() {
        Genome test1 = new Genome("XXXXXX");
        Genome test2 = new Genome("OOOOOO");
        test1.crossover(test2);
        System.out.println("Crossover: "+ test1);
    }
}
