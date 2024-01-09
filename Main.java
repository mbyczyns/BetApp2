import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isLogged = false;
        List<User> usersList = new ArrayList<>();
        User klient = new User("marcin","haslomaslo",112);
        usersList.add(klient);
        User klient2 = new User("olek", "123123",222);
        usersList.add(klient2);
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
}
