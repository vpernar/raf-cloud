package rs.raf.domaci3.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String jwt;
    private String permissions;

    public LoginResponse(String jwt, String permissions) {
        this.jwt = jwt;
        this.permissions = permissions;
    }
}