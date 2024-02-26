/**
 * The Seq<T> class for CS2030S 
 *
 * @author XXX
 * @version CS2030S AY23/24 Semester 2
 */
class Seq<T extends Comparable<T>> { // TODO: Change to bounded type parameter
  private T[] seq;

  public Seq(int size) {
    // TODO
    // The only way we can put an object into Seq is through
    // the method set() and we only put object of type T inside.
    // So it is safe to cast `Comparable[]` to `T[]`.
    @SuppressWarnings({"unchecked", "rawtypes"})
    T[] a = (T[]) new Comparable[size];
    this.seq = a;
  }

  public void set(int index, T item) {
    // TODO
    this.seq[index] = item;
  }

  public T get(int index) {
    // TODO
    return this.seq[index];
  }

  public T min() {
    // TODO
    T min = null;
    for (T obj : this.seq) {
      if (min == null) {
        min = obj;
      } else if (min.compareTo(obj) > 0) {
        min = obj;
      }
    } 
    return min;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < this.seq.length; i++) {
      s.append(i + ":" + this.seq[i]);
      if (i != this.seq.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
