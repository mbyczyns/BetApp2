package Coupons;

import Disciplines.AbstractDiscipline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractCoupon {
    protected List<String> couponList = new ArrayList<>();
    protected float totalOdds;
    Scanner scanner = new Scanner(System.in);

    public AbstractCoupon(float totalOdds) {
        this.totalOdds = 1f;
    }

    public void addBets(List<String> couponList, Scanner scanner){
        while(true){
            System.out.println("Give the keyword of the bet you want to add to your coupon. Remember, you can add only one bet from each category.");
            String bet = scanner.nextLine();
            if (bet.equals("exit")) {
                break;
            }
            else{
                couponList.add(bet);
            }
        }
    }

    public float getTotalOdds() {
        return totalOdds;
    }

    public void setTotalOdds() {
        this.totalOdds = 12.5f;
    }
}
