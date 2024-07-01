package egcdev.barcontrol.model.responses;

public class LoginResponse {

    private String token;

    private long expiresIn;

    // Getters and setters...

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
