package Coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractCoupon {
    protected float totalOdds;
    protected List<String> betList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public AbstractCoupon() {
        this.totalOdds = 1f;
        this.betList = betList;
    }

     public void addBets(){
        while(true){
            System.out.println("Give the keyword of the bet you want to add to your coupon. You can find the keywords of your bets in the file 'sports.txt'.");
            System.out.println("When you have finalized your coupon, type 'done' ");
            String bet = scanner.nextLine();
            if (bet.equals("done")) {
                break;
            }
            else{
                betList.add(bet);
            }
        }
    }

    public List<String> getCoupon(){
        return this.betList;
    }

    public float getTotalOdds() {
        return totalOdds;
    }

}
