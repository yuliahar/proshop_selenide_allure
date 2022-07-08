package com.proshop.pages;

import com.codeborne.selenide.SelenideElement;
import com.proshop.data.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    final String URL = "/login";

    SelenideElement emailLabel = $("[for='email']"),
            emailInput = $("#email"),
            passwordLabel = $("[for='password']"),
            passwordInput = $("#password"),
            registerLink = $("[data-cy='registerLink']"),
            title = $("h1"),
            errorMessage = $(".alert-danger"),
            loginButton = $(".btn-primary");

    public LoginPage navigate() {
        open(this.URL);
        return this;
    }

    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public SelenideElement getRegisterLink() {
        return registerLink;
    }

    public SelenideElement getTitle() {
        return title;
    }

    public void submitForm() {
        loginButton.click();
    }

    public LoginPage fillOutForm(User user) {
        this.setEmail(user.getEmail())
                .setPassword(user.getPassword());
        return this;
    }
}
