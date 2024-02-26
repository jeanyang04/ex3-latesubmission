public class ServiceEnd extends Event {

  private Customer customer;

  private Counter counter;

  private Bank bank;

  public ServiceEnd(Customer customer, double time, Counter counter, Bank bank) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.bank = bank;
  }

  @Override
  public String toString() {
    return super.toString() +
      String.format(": %s %s done (by S%s) %s", this.customer.toString(),
          this.customer.taskToString(), this.counter.toString(), this.customer.printStatus());
  }

  @Override 
  public Event[] simulate() {
    this.counter.toggleCounterTrue();
    if (this.counter.hasCustomer() && this.bank.hasCustomer()) {
      Customer nextCustomer = this.counter.queueDeq();
      return new Event[] {
        new DepartureEvent(this.getTime(), this.customer),
        new ServiceBegin(nextCustomer, this.getTime(), this.counter, this.bank),
        new JoinCounterQueueEvent(this.getTime() + 0.01, this.bank.queueDeq(), this.counter)
      };
    }

    if (this.counter.hasCustomer()) {
      Customer nextCustomer = this.counter.queueDeq();
      return new Event[] {
        new DepartureEvent(this.getTime(), this.customer),
        new ServiceBegin(nextCustomer, this.getTime(), this.counter, this.bank)
      };
    }

    if (this.bank.hasCustomer()) {
      Customer nextCustomer = this.bank.queueDeq();
      return new Event[] {
        new DepartureEvent(this.getTime(), this.customer),
        new ServiceBegin(nextCustomer, this.getTime(), this.counter, this.bank)
      }; 
    }

    return new Event[] {
      new DepartureEvent(this.getTime(), this.customer)
    };
  }  
}
