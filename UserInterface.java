public interface UserInterface {
    boolean login(String username,String password);

    void logout();

    int getWallet();

    void addMoney(int amount);

    void cashOut(int amount);

    String getUsername();

    String getPassword();

    boolean getisLogged();

}
