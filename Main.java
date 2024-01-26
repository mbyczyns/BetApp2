import Coupons.DicerollCoupon;
import Coupons.FootballCoupon;
import Disciplines.Diceroll;
import Disciplines.FootballMatch;
import User.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void createUser(Scanner scanner, List<User> usersList) {
        System.out.println("Creating new user");

        boolean correctUsername = false;
        String givenUsername = "";

        while (!correctUsername) {
            System.out.print("Username: ");
            givenUsername = scanner.nextLine();

            // Check if the username already exists
            boolean usernameExists = false;
            for (User tempUser : usersList) {
                if (givenUsername.equals(tempUser.getUsername())) {
                    System.out.println("User already exists. Try another username.");
                    usernameExists = true;
                    break;
                }
            }

            if (!usernameExists) {
                System.out.println("Username is good :)");
                correctUsername = true;
            }
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("User ID: ");
        int userID = scanner.nextInt();
        User user = new User(givenUsername, password, userID);
        usersList.add(user);
    }
    public static void listUsers(List<User> userList){
        for (User mini : userList){
            System.out.println(mini.getUsername());
        }
    }

    public static void logIn(List<User> usersList,Scanner scanner){
        boolean isLogged = false;
        while(!isLogged){
            System.out.print("Your username: ");
            String givenUsername = scanner.nextLine();
            for (User tempUser : usersList) {
                if (givenUsername.equals(tempUser.getUsername())) {
                    System.out.print("Your password: ");
                    String givenPassword = scanner.nextLine();
                    if (tempUser.login(givenUsername, givenPassword)) isLogged = true;
                    break;
                }
            }
            if(!isLogged) System.out.println("User not found :( Try again.");
        }
    }
    public static float makeFootballBet(float money,FootballCoupon kupon, int Agoals, int Bgoals){
        kupon.checkFootballCoupon(Agoals,Bgoals);
        return kupon.getTotalOdds()*money;
    }
    public static float makeDicerollBet(float money, DicerollCoupon kupon,int diceResult){
        kupon.checkDicerollCoupon(diceResult);
        return kupon.getTotalOdds()*money;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<User> usersList = new ArrayList<>();
        User klient = new User("user","password",112);
        usersList.add(klient);
        logIn(usersList, scanner);
        System.out.println("Your wallet: "+ klient.getWallet());
        System.out.println("What sport would you like to bet?");
        System.out.println("1 - Football ");
        System.out.println("2 - Diceroll :)");
        int sportChoice = scanner.nextInt();
        System.out.println("Now enter the amount of money you would like to put on your bet: ");
        float money = scanner.nextFloat();
            if (sportChoice==1){
                FootballMatch mecz = new FootballMatch();
                FootballCoupon kupon = new FootballCoupon();
                kupon.addBets();
                float potentialPrize = makeFootballBet(money,kupon, mecz.getTeamAgoals(), mecz.getTeamBgoals());
                klient.takeMoney(money);
                klient.addMoney(potentialPrize);
            } else if (sportChoice==2) {
                Diceroll rzut = new Diceroll();
                DicerollCoupon kupon = new DicerollCoupon();
                kupon.addBets();
                makeDicerollBet(money,kupon, rzut.getDiceResult());
                klient.takeMoney(money);
            }
            else{
                System.out.println("wrong sport number :(");
            }

    }
}
