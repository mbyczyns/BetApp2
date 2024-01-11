import Disciplines.FootballMatch;
import User.User;

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
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<User> usersList = new ArrayList<>();
        User klient = new User("marcin","haslomaslo",112);
        usersList.add(klient);
        User klient2 = new User("olek", "123123",222);
        FootballMatch mecz = new FootballMatch();
        System.out.println(mecz.getTeamA());
        System.out.println(mecz.getTeamB());
        System.out.println(mecz.getTeamAgoals());
        System.out.println(mecz.getTeamBgoals());
        System.out.println(mecz.draw(mecz.getTeamAgoals(), mecz.getTeamBgoals()));
    }


}
