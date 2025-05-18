package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String email;
    private String password;

    public String getUsername() {
        return email.substring(0, email.indexOf("@"));
    }
}
