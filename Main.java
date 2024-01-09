import User.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        User klient = new User("marcin","haslomaslo",112);
        Scanner scanner = new Scanner(System.in);
        while(!klient.getisLogged()){
            System.out.print("Your username: ");
            String givenUsername = scanner.nextLine();
            System.out.print("Your password: ");
            String givenPassword = scanner.nextLine();
            klient.login(givenUsername,givenPassword);
        }
    }
}
