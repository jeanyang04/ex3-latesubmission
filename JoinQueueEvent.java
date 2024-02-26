class JoinQueueEvent extends Event {

  private Customer customer;

  private Bank bank;

  public JoinQueueEvent(double time, Customer customer, Bank bank) {
    super(time);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    String str = String.format(": %s joined bank queue %s", 
        this.customer.toString(), this.bank.queueToString());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    if (!this.bank.queueIsFull() && this.customer != null) {
      this.bank.queueEnq(this.customer);
    } 
    return new Event[] {};
  }
}
