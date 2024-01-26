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

    public static void createUser( List<User> usersList) {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("Welcome "+ givenUsername);
    }
    public static void listUsers(List<User> userList){
        for (User mini : userList){
            System.out.println(mini.getUsername());
        }
    }

    public static void logIn(List<User> usersList){
        Scanner scanner = new Scanner(System.in);
        boolean isLogged = false;
        while(!isLogged){
            System.out.print("Your username: ");
            String givenUsername = scanner.nextLine();
            for (User tempUser : usersList) {
                if (givenUsername.equals(tempUser.getUsername())) {
                    System.out.print("Your password: ");
                    String givenPassword = scanner.nextLine();
                    if (tempUser.login(givenUsername, givenPassword)) isLogged = true;
                    System.out.println("Welcome "+ givenUsername);
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


    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        List<User> usersList = new ArrayList<>();
        User klient = new User("user", "password", 112);
        usersList.add(klient);
        System.out.printf("Do you want to log in as an existing user (type 1), or do you want to create a new user account? (type 2)");
        int loggingChoice = scanner1.nextInt();
        if (loggingChoice==1){
            logIn(usersList);
        }
        else if (loggingChoice==2) {
            createUser(usersList);
        }
        while (true) {
            System.out.println("----------------");
            System.out.println();
            System.out.println("Your wallet: " + klient.getWallet());
            System.out.println("What sport would you like to do?");
            System.out.println("1 - Bet on Football ");
            System.out.println("2 - Bet on Diceroll :)");
            System.out.println("3 - Add money to your wallet");
            System.out.println("4 - Cash out your money");
            System.out.println("5 - Exit program");
            int sportChoice = scanner1.nextInt();
            if (sportChoice == 1) {
                System.out.println("Now enter the amount of money you would like to put on your bet: ");
                float money = scanner1.nextFloat();
                FootballMatch mecz = new FootballMatch();
                FootballCoupon kupon = new FootballCoupon();
                kupon.addBets();
                float potentialPrize = makeFootballBet(money, kupon, mecz.getTeamAgoals(), mecz.getTeamBgoals());
                klient.takeMoney(money);
                System.out.println("Your bets:");
                for (String bet : kupon.getCoupon()){
                    System.out.println(bet);
                }
                System.out.println();
                System.out.println("Match results:");
                System.out.println("Real Madrid "+ mecz.getTeamAgoals() + " - " +mecz.getTeamBgoals() + " Barcelona");
                if (potentialPrize > 0 ){
                    System.out.println("Congratulations! You won! Your prize: "+ potentialPrize);
                }
                else{
                    System.out.println("Sorry, you lost :(");
                }
                System.out.println();
                klient.addMoney(potentialPrize);
            } else if (sportChoice == 2) {
                System.out.println("Now enter the amount of money you would like to put on your bet: ");
                float money = scanner1.nextFloat();
                Diceroll rzut = new Diceroll();
                DicerollCoupon kupon = new DicerollCoupon();
                kupon.addBets();
                float potentialPrize = makeDicerollBet(money, kupon, rzut.getDiceResult());
                klient.takeMoney(money);
                klient.addMoney(potentialPrize);
            } else if (sportChoice ==3){
                System.out.println("How much money would you like to add to your wallet?");
                klient.addMoney(scanner1.nextFloat());
            }
            else if (sportChoice ==4) {
                System.out.println("How much money would you like to cash out?");
                klient.takeMoney(scanner1.nextFloat());
            }
            else if (sportChoice ==5){
                System.out.println("Exiting ...");
                break;
            }
        }
    }
}
