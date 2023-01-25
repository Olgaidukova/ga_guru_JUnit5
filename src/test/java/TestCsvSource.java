import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestCsvSource {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
    }

    @CsvSource({
            "42006175157583, Посылка из Казани",
            "80520775364115, Письмо из Санкт-Петербурга"
    })
    @ParameterizedTest(name = "В результате отслеживания трек-номера {0} получаем {1}")
    void pochtaSearchTest(
            String trackNumber,
            String productType
    ) {
        open("https://www.pochta.ru/");
        $("#barcode").setValue(trackNumber).pressEnter();
        $("#tracking-card-portal").shouldHave(text(productType));
    }

}
