package com.proshop.pages;

import com.codeborne.selenide.SelenideElement;
import com.proshop.data.User;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {
    final String URL = "/register";

    SelenideElement firstNameInput = $("#firstname"),
            lastNameInput = $("#lastname"),
            emailInput = $("#email"),
            usernameInput = $("#username"),
            passwordInput = $("#password"),
            confirmPasswordInput = $("#password2"),
            loginLink = $("[data-cy=\"loginLink\"]"),
            title = $("h1"),
            submitButton = $(".btn-primary");
    public RegisterPage navigate() {
        open(this.URL);
        return this;
    }

    public RegisterPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegisterPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public RegisterPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegisterPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String password) {
        confirmPasswordInput.setValue(password);
        return this;
    }

    public SelenideElement getLoginLink() {
        return loginLink;
    }

    public SelenideElement getTitle() {
        return title;
    }

    public void submitForm() {
        submitButton.click();
    }

    public RegisterPage fillOutForm(User user) {
        this.setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setConfirmPassword(user.getPassword());
        return this;
    }
}
