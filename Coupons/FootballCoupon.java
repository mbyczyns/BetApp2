package Coupons;

import Disciplines.FootballMatch;

import java.util.ArrayList;
import java.util.List;

public class FootballCoupon  extends AbstractCoupon {
    public FootballCoupon() {
        super();
    }

    public void checkCoupon(int Agoals, int Bgoals){
        System.out.println(totalOdds);
        for (String bet : betList){
            switch (bet){
                case "awin":
                    if (Bgoals < Agoals) totalOdds*= 3.0F;
                    else totalOdds *= 0;
                    break;
                case "bwin":
                    if (Bgoals > Agoals) totalOdds*= 3.0F;
                    else totalOdds *= 0;
                    break;
                case "draw":
                    if (Bgoals == Agoals) totalOdds*= 8.0F;
                    else totalOdds *= 0;
                    break;
                case "more4":
                    if (Bgoals + Agoals > 4) totalOdds*= 1.5F;
                    else totalOdds *= 0;
                    break;
                case "more6":
                    if (Bgoals + Agoals > 6) totalOdds*= 2.5F;
                    else totalOdds *= 0;
                    break;
                case "more8":
                    if (Bgoals + Agoals > 8) totalOdds*= 4.0F;
                    else totalOdds *= 0;
                    break;
                case "nogoal":
                    if (Bgoals==0 || Agoals==0) totalOdds*= 3.5F;
                    else totalOdds *= 0;
                    break;
                default:
                    System.out.println("A wrong bet has been added. Sorry for your money :(");
                    totalOdds*=0;


            }
        }
    }


}
