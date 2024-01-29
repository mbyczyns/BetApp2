import Coupons.DicerollCoupon;
import Coupons.FootballCoupon;
import Disciplines.Diceroll;
import Disciplines.FootballMatch;
import User.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void createUser( List<User> usersList) { //creating a new user
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
                System.out.println("Username is good :)"); //given username has been foung in the list of users
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
    public static void listUsers(List<User> userList){ //print users
        for (User mini : userList){
            System.out.println(mini.getUsername());
        }
    }

    public static void logIn(List<User> usersList){ //logging in as an existing user
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
    public static float makeFootballBet(float money,FootballCoupon coupon, int Agoals, int Bgoals){
        coupon.checkFootballCoupon(Agoals,Bgoals);
        return coupon.getTotalOdds()*money;
    }
    public static float makeDicerollBet(float money, DicerollCoupon coupon,int diceResult){
        coupon.checkDicerollCoupon(diceResult);
        return coupon.getTotalOdds()*money;
    }


    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        List<User> usersList = new ArrayList<>();
        User customer = new User("user", "password", 112); //creating a default customer
        usersList.add(customer);
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
            System.out.println("Your wallet: " + customer.getWallet());
            System.out.println("What would you like to do?");
            System.out.println("1 - Bet on Football ");
            System.out.println("2 - Bet on Diceroll :)");
            System.out.println("3 - Add money to your wallet");
            System.out.println("4 - Cash out your money");
            System.out.println("5 - Exit program");
            int sportChoice = scanner1.nextInt();
            if (sportChoice == 1) { //making a footbal bid
                System.out.println("Now enter the amount of money you would like to put on your bet: ");
                float money = scanner1.nextFloat();
                if(money> customer.getWallet()){
                    System.out.println("You don't have enough money to make this bet. Add money to your wallet and come back!");
                }
                else {
                    FootballMatch match = new FootballMatch();
                    FootballCoupon coupon = new FootballCoupon();
                    coupon.addBets();
                    float potentialPrize = makeFootballBet(money, coupon, match.getTeamAgoals(), match.getTeamBgoals());
                    customer.takeMoney(money);
                    System.out.println("Your bets:");
                    for (String bet : coupon.getCoupon()) {
                        System.out.println(bet);
                    }
                    System.out.println();
                    System.out.println("Match results:");
                    System.out.println("Real Madrid " + match.getTeamAgoals() + " - " + match.getTeamBgoals() + " Barcelona");
                    if (potentialPrize > 0) {
                        System.out.println("Congratulations! You won! Your prize: " + potentialPrize);
                    } else {
                        System.out.println("Sorry, you lost :(");
                    }
                    System.out.println();
                    customer.addMoney(potentialPrize);
                }
            } else if (sportChoice == 2) { //making a diceroll bid
                System.out.println("Now enter the amount of money you would like to put on your bet: ");
                float money = scanner1.nextFloat();
                if(money> customer.getWallet()){
                    System.out.println("You don't have enough money to make this bet. Add money to your wallet and come back!");
                }
                else {
                    Diceroll throwDice = new Diceroll();
                    DicerollCoupon kupon = new DicerollCoupon();
                    kupon.addBets();
                    float potentialPrize = makeDicerollBet(money, kupon, throwDice.getDiceResult());
                    customer.takeMoney(money);
                    customer.addMoney(potentialPrize);
                }
            } else if (sportChoice ==3){ //adding money to wallet
                System.out.println("How much money would you like to add to your wallet?");
                customer.addMoney(scanner1.nextFloat());
            }
            else if (sportChoice ==4) { //cashing out money
                System.out.println("How much money would you like to cash out?");
                customer.takeMoney(scanner1.nextFloat());
            }
            else if (sportChoice ==5){ //exiting the program
                System.out.println("Exiting ...");
                break;
            }
        }
    }
}
