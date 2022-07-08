package com.proshop.tests;

import com.proshop.data.User;
import com.proshop.pages.HomePage;
import com.proshop.pages.LoginPage;
import com.proshop.pages.RegisterPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

@Story("Sign up tests")
@Tag("signup")
public class SignupTests extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void beforeEach() {
        step("Open register page", () -> {
            registerPage.navigate();
        });
    }

    @Test
    @Tags({@Tag("smoke"), @Tag("regression")})
    @Owner("yuliaHar")
    @Description("Verify that a visitor can register to the site")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify that user can register to the site with valid data")
    void signupWithValidDataTest() {
        User fakeUser = new User.UserBuilder().createFakeUser();

        step("Fill out form with valid data", () -> {
            registerPage.fillOutForm(fakeUser);
        });

        step("Submit form", () -> {
            registerPage.submitForm();
        });

        step("Verify that user has been created and authorized", () -> {
            homePage.getUsernameLink().shouldHave(text(fakeUser.getUsername().toUpperCase()));
        });

        // TODO: ...
//        step("Remove created user via API", () -> {
//
//        });
    }

    @Test
    @Tag("ui")
    @Owner("yuliaHar")
    @Description("Login link should be visible")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Verify that login link is present on the page")
    void loginLinkPresenceTest() {
        step("Verify that login link is present on the page", () -> {
            registerPage.getLoginLink().shouldBe(visible).shouldHave(text("Login"));
        });
    }

    @Test
    @Tag("ui")
    @Owner("yuliaHar")
    @Description("Page title should be visible and have text 'Sign Up'")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Verify page title")
    void pageTitlePresenceTest() {
        step("Verify that page title should be visible and have text 'Sign Up'", () -> {
            registerPage.getTitle().shouldBe(visible).shouldHave(text("Sign Up"));
        });
    }

    @Test
    @Tag("regression")
    @Owner("yuliaHar")
    @Description("Verify that user can go back to login page by clicking login link")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify that user can navigate to login page by clicking login link")
    void navigateToLoginPageTest() {
        step("Navigate to login page by clicking login link", () -> {
            registerPage.getLoginLink().click();
        });

        step("Verify that user is on the Login page", () -> {
            loginPage.getTitle().shouldBe(visible).shouldHave(text("Sign In"));
        });
    }

    @Test
    @Tag("regression")
    @Owner("yuliaHar")
    @Description("Verify that user can signup with username = 3 chars")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify that user can register with min username length")
    void registerUserWithMinUsernameTest() {
        User fakeUser = new User.UserBuilder().createFakeUser();

        step("Fill out form with valid data", () -> {
            registerPage.fillOutForm(fakeUser);
        });

        step("Submit form", () -> {
            registerPage.submitForm();
        });

        step("Verify that user has been created and authorized", () -> {
            homePage.getUsernameLink().shouldHave(text(fakeUser.getUsername().toUpperCase()));
        });

        // TODO: ...
//        step("Remove created user via API", () -> {
//
//        });
    }
}