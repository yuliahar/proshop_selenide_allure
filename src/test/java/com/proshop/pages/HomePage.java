package com.proshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    final String URL = "/";

    SelenideElement usernameLink = $("a#username");

    public HomePage navigate() {
        open(this.URL);
        return this;
    }

    public SelenideElement getUsernameLink() {
        return usernameLink;
    }
}
