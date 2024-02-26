public class Customer {
  private int customerId;

  private double serviceTime;
  
  private Task taskType;

  public Customer(int customerId, double serviceTime, Task taskType) {
    this.customerId = customerId;
    this.serviceTime = serviceTime;
    this.taskType = taskType;
  }

  public String printJoinQueue(Bank bank) {
    String str = String.format(": C%d joined queue %s", this.customerId, bank.queueToString());
    return str;
  }

  public double calculateEndTime(double time) {
    return time + this.serviceTime;
  }
  
  @Override
  public String toString() {
    String str = String.format("C%d", this.customerId);
    return str;
  }

  public String taskToString() {
    return this.taskType.toString(); 
  }

  public String printStatus() {
    return this.taskType.printStatus();
  }

  public int calculateBalance(int counterBalance) {
    return this.taskType.calculateResult(counterBalance); 
  }

  public Counter goToCounter(Bank bank) {
    return bank.getAvailableCounter();
  }

  public Counter goToCounterQueue(Bank bank) {
    Counter counter = bank.getShortestQueue();
    if (counter.queueIsFull()) {
      return null;
    } else {
      return counter;
    }
  } 
}
