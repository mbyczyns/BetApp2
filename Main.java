import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public void createUser(Scanner scanner, List<User> usersList){
        System.out.println("Creating new user");
        String givenUsername = scanner.nextLine();
        boolean correctUsername = false;
        while (!correctUsername) {
            System.out.print("Username: ");
            for (User tempUser : usersList) {
                if (givenUsername.equals(tempUser.getUsername())) {
                    System.out.println("User already exists. Try another username.");
                    correctUsername = false;
                    break;
                } else correctUsername = true;
            }

        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("User ID: ");
        int userID = scanner.nextInt();
        User user = new User(givenUsername, password, userID);
        usersList.add(user);
    }

    public void logIn(String userName, String password, int userID, List<User> usersList,Scanner scanner){
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
        usersList.add(klient2);
    }
}
