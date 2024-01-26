package User;

public interface UserInterface {
    boolean login(String username,String password);

    void logout();

    float getWallet();

    float addMoney(int amount);

    void takeMoney(int amount);

    String getUsername();

    String getPassword();

    boolean getisLogged();

}
