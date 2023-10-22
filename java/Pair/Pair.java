

class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>> {
    public final F fst;
    public final S snd;

    private Pair(F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public static <F extends Comparable<F>, S extends Comparable<S>> Pair<F, S> of(F fst, S snd) {
        return new Pair<>(fst, snd);
    }

    @Override
    public int compareTo(Pair<F, S> o) {
        int cmpFst = this.fst.compareTo(o.fst);
        return cmpFst != 0 ? cmpFst : this.snd.compareTo(o.snd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(fst, pair.fst) && Objects.equals(snd, pair.snd);
    }

    @Override
    public String toString() {
        return String.format("Pair{ %s, %s }", this.fst, this.snd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }
}