public class Bank {
  private Seq<Counter> counters;

  private Queue<Customer> queue;

  public Counter getAvailableCounter() {
    for (int i = 0; i < this.numOfCounters; i++) {
      if (counters.get(i).isAvailable()) {
        return counters.get(i);
      }
    }
    return null;
  }
  
  private int numOfCounters;

  private int counterId = 0;

  public Bank(int numOfCounters, int counterQueueLen, Queue<Customer> queue) {
    this.numOfCounters = numOfCounters;
    this.queue = queue;
    this.counters = new Seq<Counter>(numOfCounters);
    for (int i = 0; i < numOfCounters; i++) {
      this.counters.set(i, new Counter(counterId, counterQueueLen));
      this.counterId++;
    }
  }

  public Counter getShortestQueue() {
    return this.counters.min();
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

  public boolean hasCustomer() {
    return this.hasQueue() && !this.queueIsEmpty();
  }

  public boolean queueIsFull() {
    return this.queue.isFull();
  }

  public String queueToString() {
    return this.queue.toString();
  }
  
}
