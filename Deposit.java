class Deposit extends Task {
  private int money;

  private String status = "";

  public Deposit(int money) {
    this.money = money;
  }

  @Override
  public int calculateResult(int balance) {
    return balance + money;
  }

  @Override
  public String toString() {
    return String.format("deposit $%d", this.money);
  }

  @Override
  public String printStatus() {
    return "success";
  }
}
