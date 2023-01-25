import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestValueSource {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {
            "42006175157583",
            "80520775364115"
    })
    @ParameterizedTest(name = "Отслеживается трек-номер {0}")
    void pochtaSearchTest(String trackNumber) {
        open("https://www.pochta.ru/");
        $("#barcode").setValue(trackNumber).pressEnter();
        $("#tracking-card-portal").shouldHave(text(trackNumber));
    }
}
