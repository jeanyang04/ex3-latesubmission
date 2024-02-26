class JoinCounterQueueEvent extends Event {

  private Customer customer;

  private Counter counter;

  public JoinCounterQueueEvent(double time, Customer customer, Counter counter) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public String toString() {
    String str = String.format(": %s joined counter queue (at S%s)", 
        this.customer.toString(), this.counter.toString());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    if (this.counter != null && this.customer != null) {
      this.counter.queueEnq(this.customer);
    }
    return new Event[] {};
  }
}
