import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;

//import java.awt.*;

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
        open("/text-box");
        $("#userName").setValue("First_lastName");
        $("#userEmail").setValue("First_lastName@Email.com");
        $("#currentAddress").setValue("Current address");
        $("#permanentAddress").setValue("Permanent address");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
    }
}