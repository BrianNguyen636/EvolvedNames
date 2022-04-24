import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 @Author Brian Nguyen
 */

public class Population {
    Genome mostFit;
    List<Genome> populace = new LinkedList<>();

    Population(Integer numGenomes, Double mutationRate) {
        for (int i = 0; i < numGenomes; i++) {
            populace.add(new Genome(mutationRate));
        }
        mostFit = populace.get(0);
    }
    /*
    test constructor
     */
    Population(List<Genome> test) {
        this.populace = test;
        mostFit = populace.get(0);
    }

    void day() {
        Random random = new Random();
        int size = populace.size();
        populace.sort(new fitnessComparator());
        mostFit = populace.get(populace.size()-1);
        if (size / 2 > 0) {
            populace.subList(0, size / 2).clear();
        }
        while (populace.size() != size) {
            int rand = random.nextInt(2);
            Genome clone = new Genome(populace.get(random.nextInt(size/2)));
            if (rand == 1) {
                clone.crossover(populace.get(random.nextInt(size/2)));
            }
            clone.mutate();
            populace.add(clone);
        }
    }
}
class fitnessComparator implements Comparator<Genome> {
    @Override
    public int compare(Genome o1, Genome o2) {
        return o2.fitness() - o1.fitness();
    }
}
