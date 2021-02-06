package Repository;

public interface IRepository {
    abstract void add(Comparable o);
    abstract void update(int i, Comparable o);
    abstract void delete(int i);
    abstract void clearEl();
    abstract void citireDinFisier();
    abstract int getLungime();

}
