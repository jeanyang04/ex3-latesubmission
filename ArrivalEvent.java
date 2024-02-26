public class ArrivalEvent extends Event {

  private Customer customer;
  
  private Bank bank;

  public ArrivalEvent(double time, Customer customer, Bank bank) {
    super(time);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    return super.toString() + 
      String.format(": %s arrived %s", this.customer.toString(), this.bank.queueToString()); 
  }

  @Override 
  public Event[] simulate() {
    Counter availableCounter = this.customer.goToCounter(bank);
    Counter shortestCounter = this.customer.goToCounterQueue(bank);

    if (availableCounter != null) {
      return new Event[] {
        new ServiceBegin(this.customer, this.getTime(), availableCounter, this.bank)
      };
    }

    if (shortestCounter != null) {
      return new Event[] {
        new JoinCounterQueueEvent(this.getTime(), this.customer, shortestCounter)
      };
    }

    if (!this.bank.queueIsFull()) {
      return new Event[] {
        new JoinQueueEvent(this.getTime(), this.customer, this.bank)
      };
    }
    
    return new Event[] {
      new DepartureEvent(this.getTime(), this.customer)
    };
  }
}
