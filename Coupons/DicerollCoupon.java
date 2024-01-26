package Coupons;

public class DicerollCoupon extends AbstractCoupon {
    public DicerollCoupon(){
        super();
    }

    public void checkDicerollCoupon(int dice) {
        for (String bet : betList) {
            switch (bet) {
                case "more2":
                    if (dice >2) totalOdds *= 1.3F;
                    else totalOdds *= 0;
                    break;
                case "more4":
                    if (dice >4) totalOdds *= 2.0F;
                    else totalOdds *= 0;
                    break;
                case "even":
                    if (dice %2 == 0) totalOdds *= 2.0F;
                    else totalOdds *= 0;
                    break;
                case "odd":
                    if (dice %2 != 0) totalOdds *= 2.0F;
                    else totalOdds *= 0;
                    break;
                case "ex1":
                    if (dice ==1) totalOdds *= 6.0F;
                    else totalOdds *= 0;
                    break;
                case "ex2":
                    if (dice ==2) totalOdds *= 6.0F;
                    else totalOdds *= 0;
                    break;
                case "ex3":
                    if (dice ==3) totalOdds *= 6.0F;
                    else totalOdds *= 0;
                    break;
                case "ex4":
                    if (dice ==4) totalOdds *= 6.0F;
                    else totalOdds *= 0;
                    break;
                case "ex5":
                    if (dice ==5) totalOdds *= 6.0F;
                    else totalOdds *= 0;
                    break;
                case "ex6":
                    if (dice ==6) totalOdds *= 6.0F;
                    else totalOdds *= 0;
                    break;
                default:
                    totalOdds *= 0;
            }
        }
    }
}
