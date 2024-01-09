package User;

public class User implements UserInterface {
    private int userID;
    private String username;
    private String password;
    private int wallet;
    private boolean isLogged;

    public User(String username, String password, int userID) {
        this.password = password;
        this.username = username;
        this.userID = userID;
        this.wallet = 100;
        this.isLogged = false;
    }

    @Override
    public boolean login(String givenUsername, String givenPassword) {
        if (givenUsername.equals(this.username) && givenPassword.equals(this.password)){
            this.isLogged = true;
            System.out.println(this.username+" logged in succesfully!");
            return true;
        }
        else{
            System.out.println("Failed to log in. Try again.");
            return false;
        }
    }

    @Override
    public void logout() {
        this.isLogged=false;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getWallet() {
        return wallet;
    }

    @Override
    public boolean getisLogged() {
        return isLogged;
    }

    @Override
    public void addMoney(int amount) {
        wallet+=amount;
    }

    @Override
    public void cashOut(int amount) {
        wallet-=amount;
    }

}
