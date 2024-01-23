package Coupons;

import Disciplines.AbstractDiscipline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractCoupon {
    protected List<String> couponList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public AbstractCoupon(List<String> couponList) {
        this.couponList = couponList;
    }
    public void addBets(List<String> couponList, Scanner scanner){
        while(true){
            System.out.println("Give the keyword of the bet you want to add to your coupon. Remember, you can add only one bet from each category.");
        }
    }

}
