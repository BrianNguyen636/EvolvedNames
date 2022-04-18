public class Genome {
    static final String[] alpha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
            "O","P","Q","R","S","T","U","V","W", "X","Y","Z", " ","'", "-"};
    static final String target = "BRIAN NGUYEN";
    String value;
    double theMutationRate;

    Genome(double mutationRate) {
        value = "A";
        theMutationRate = mutationRate;
    }
    Genome(Genome gene) {
        value = gene.value;
        theMutationRate = gene.theMutationRate;
    }
    void mutate() {

    }
    void crossover(Genome other) {

    }
    int fitness() {
        int n = target.length();
        int m = value.length();
        int L = Math.max(n,m);
        int f = Math.abs(m-n);
        for (int i = 0; i < L; i++) {
            if (value.charAt(i) != target.charAt(i)) { //Also check for empty character
                f++;
            }
        }
        return f;
    }
    public String toString() {
        return "Fitness: " + fitness() + " Gene: " + value;
    }

}
