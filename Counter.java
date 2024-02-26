public class Counter implements Comparable<Counter> {

  private int counterId;
  
  private boolean availability = true;

  private Queue<Customer> queue;

  private int balance = 100;

  public Counter(int counterId, int queueLen) {
    this.counterId = counterId;
    this.availability = true;
    this.queue = new Queue<Customer>(queueLen);
  }

  public boolean isAvailable() {
    return availability;
  }
  
  public void toggleCounterTrue() {
    this.availability = true;
  }

  public void toggleCounterFalse() {
    this.availability = false;
  }

  public void processCustomer(Customer customer) {
    int resultBalance = customer.calculateBalance(balance);
    if (resultBalance >= 0) {
      this.balance = resultBalance;
    }
  }

  public int compareTo(Counter counter) {
    return Integer.compare(this.queue.length(), counter.queue.length());
  }

  @Override
  public String toString() {
    return String.format("%d $%d %s", this.counterId, this.balance, this.queue.toString());
  }

  public Customer queueDeq() {
    return this.queue.deq();
  }

  public void queueEnq(Customer customer) {
    this.queue.enq(customer);
  }

  public boolean queueIsEmpty() {
    return this.queue.isEmpty();
  }

  public boolean hasQueue() {
    return this.queue.exists();
  }   

  public boolean queueIsFull() {
    return this.queue.isFull();
  }

  public boolean hasCustomer() {
    return this.hasQueue() && !this.queueIsEmpty();
  }

  public String queueToString() {
    return this.queue.toString();
  }
}
