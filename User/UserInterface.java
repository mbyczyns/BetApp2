package User;

public interface UserInterface {
    boolean login(String username,String password);

    void logout();

    float getWallet();

    void addMoney(float amount);

    void takeMoney(float amount);

    String getUsername();

    String getPassword();

    boolean getisLogged();

}
