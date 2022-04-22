import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Genome {
    static final Character[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z',' ','\'', '-'};
    static final String target = "PAULO  SERGIO  LICCIARDI \n" +
            "MESSEDER BARRETO";
    List<Character> value;
    double theMutationRate;
    static Random random = new Random();

    Genome(double mutationRate) {
        value = new LinkedList<>();
        value.add('A');
        theMutationRate = mutationRate;
    }
    Genome(Genome gene) {
        value = gene.value;
        theMutationRate = gene.theMutationRate;
    }
    void mutate() {
        if (rollMutate()) {
            int index = random.nextInt(value.size());
            value.add(index, alpha[random.nextInt(alpha.length)]);
        }
        if (rollMutate() && value.size() >= 2) {
            int index = random.nextInt(value.size());
            value.remove(index);
        }
        for (int i = 0; i < value.size(); i++) {
            if (rollMutate()) {
                value.set(i, alpha[random.nextInt(alpha.length)]);
            }
        }
    }
    void crossover(Genome other) {
        List<Character> cross = new LinkedList<>();
        int index = Math.max(value.size(), other.value.size());
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
                if (i < other.value.size()) {
                    cross.add(other.value.get(i));
                } else {
                    empty = true;
                }
            }
        }
        value = cross;
    }
    int fitness() {
        int n = target.length();
        int m = value.size();
        int L = Math.max(n,m);
        int f = Math.abs(m-n);
        for (int i = 0; i < L; i++) {
            if (Math.min(n,m) > i) {
                if (value.get(i) != target.charAt(i)) { //Also check for empty character
                    f++;
                }
            } else f++;
        }
        return f;
    }
    public String toString() {
        StringBuilder gene = new StringBuilder();
        for (Character c : value) {
            gene.append(c);
        }
        return "Fitness: " + fitness() + " Gene: " + gene;
    }
    /*
    Rolls to check if to mutate.
     */
    boolean rollMutate() {
        int rand = random.nextInt(100 + 1);
        return rand <= theMutationRate*100;
    }

}
