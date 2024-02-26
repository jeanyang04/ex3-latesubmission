public class ServiceBegin extends Event {

  private Customer customer;

  private Counter counter;

  private Bank bank;

  public ServiceBegin(Customer customer, double time, Counter counter, Bank bank) {
    super(time);  
    this.customer = customer;
    this.counter = counter;
    this.bank = bank;
  }
  
  public void processService(Customer customer, Counter counter) {
    counter.processCustomer(customer);
  }

  @Override
  public String toString() {
    return super.toString() + 
      String.format(": %s %s begin (by S%s)", this.customer.toString(), 
          this.customer.taskToString(), this.counter.toString());
  }

  @Override
  public Event[] simulate() {
    this.counter.toggleCounterFalse();
    processService(customer, counter);
    double endTime = this.customer.calculateEndTime(this.getTime()); 
    return new Event[] {
      new ServiceEnd(this.customer, endTime, this.counter, this.bank)
    };
  }

}

