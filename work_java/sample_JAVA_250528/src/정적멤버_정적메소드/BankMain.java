package 정적멤버_정적메소드;

public class BankMain {
    public static void main(String[] args) {
        Bank bank1 = new Bank("소히",1000);
        Bank bank2 = new Bank("지니",5000);
        Bank bank3 = new Bank("유리",135000);

        bank1.setWithdraw(2000);
        bank2.setDeposit(3500);
        bank3.viewAccount();
        System.out.println(Bank.getCount());

    }
}
