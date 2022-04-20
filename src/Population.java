import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Population {
    Genome mostFit;
    List<Genome> populace;

    Population(Integer numGenomes, Double mutationRate) {
        for (int i = 0; i < numGenomes; i++) {
            populace.add(new Genome(mutationRate));
        }
    }

    void day() {
//        Genome min = populace.get(0);
//        for (Genome gene : populace) {
//            if (gene.fitness() < min.fitness()) {
//                min = gene;
//            }
//        }
//        mostFit = min;
        Random random = new Random();
        int size = populace.size();
        populace.sort(new fitnessComparator());
        mostFit = populace.get(0);
        for (int i = size / 2; i < size; i++) {
            populace.remove(i);
        }
        while (populace.size() != size) {
            int rand = random.nextInt(2);
            Genome clone = new Genome(populace.get(random.nextInt(populace.size())));
            if (rand == 1) {
                clone.crossover(populace.get(random.nextInt(populace.size())));
            }
            clone.mutate();
            populace.add(clone);
        }

    }

}
class fitnessComparator implements Comparator<Genome> {
    @Override
    public int compare(Genome o1, Genome o2) {
        return o1.fitness() - o2.fitness();
    }
}
