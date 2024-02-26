class Withdrawal extends Task {
  private int money;

  private String status = "";

  public Withdrawal(int money) {
    this.money = money;
  }
  
  @Override
  public int calculateResult(int counterBalance) {
    int result = counterBalance - money;
    if (result < 0) {
      status = "fail";
    } else {
      status = "success";
    }
    return result;
  }

  @Override
  public String toString() {
    return String.format("withdrawal $%d", this.money);
  }

  @Override
  public String printStatus() {
    return String.format("%s", this.status);
  }
}
