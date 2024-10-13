package product;

public class user {

    private String username;
    private String password;

    public user() {
    }

    public user(String username, String password) throws IllegalArgumentException {
        setName(username);
        setPass(password);
    }

    public String getName() {
        return username;
    }

    public void setName(String username) throws IllegalArgumentException {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.username = username;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String password) throws IllegalArgumentException {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = password;
    }
}
