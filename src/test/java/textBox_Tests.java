import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class textBox_Tests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void FillFormTest() {
        String userName = "Ivan Safonov";
        String userEmail = "safonovivv@gmail.com";
        String currentAddress = "city of Moscow 1";
        String permanentAddress = "city of Moscow 2";

        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}