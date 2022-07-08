package com.proshop.data;

import static com.proshop.utils.RandomUtils.getRandomPassword;
import com.github.javafaker.Faker;

public class User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String password;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " + this.firstName + ", " + this.lastName + ", " + this.username + ", " +
                this.email + ", " + this.password;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private  String username;
        private  String email;
        private  String password;
        Faker faker = new Faker();

        public UserBuilder() {
        }

        public UserBuilder(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() {
            User user =  new User(this);
            return user;
        }
        public User createFakeUser() {
            User user =  new UserBuilder(faker.name().username(),
                    faker.internet().emailAddress(), getRandomPassword(8, true, true))
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .build();
            return user;
        }
    }
}