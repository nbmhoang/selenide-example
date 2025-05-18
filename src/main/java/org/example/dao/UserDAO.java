package org.example.dao;

import org.example.models.User;

import static org.example.utils.ConfigReader.getEmail;
import static org.example.utils.ConfigReader.getPassword;

public class UserDAO {

    /**
     * Get user from config.properties file
     *
     * @return
     */
    public static User getUser() {
        return new User(getEmail(), getPassword());
    }

}
