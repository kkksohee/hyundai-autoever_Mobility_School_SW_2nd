package 정적멤버_정적메소드;

import java.awt.*;

public class Bank {
    private static int count =0; //정적 멤버
    private int account;
    private String bank;

    Bank(String name, int account){
        count++;
        this.bank=name;
        this.account=account;
        System.out.println(name+"님 은행에 계좌를 개설합니다. 잔액은 "+account+"입니다.");
    }
    //정적 메소드
    public static int getCount(){
        return count;
    }
    //입금
    public void setDeposit(final int dep){
        this.account += dep;
        System.out.println(dep+"를 입금했습니다.");
    }
    //출금
    public void setWithdraw(final int with){
        if(this.account>=with){
            this.account -=with;
            System.out.println(with+"를 출금했습니다.");
        }else{
            System.out.println("잔액이 부족합니다.");
        }
    }
    public void viewAccount(){
        System.out.println("현재 잔액은 "+account+"입니다.");
    }

}
