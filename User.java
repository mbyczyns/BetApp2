public class User implements UserInterface {
    public int userID;
    public String username;
    public String password;

    public User(String username, String password, int userID) {
        this.password = password;
        this.username = username;
        this.userID = userID;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {
    }

    @Override
    public void getUserInfo() {
    }

    @Override
    public void addMoney() {

    }

    @Override
    public void cashOut() {

    }

}
