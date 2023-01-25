import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCsvFileSource {


    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
    }

    @CsvFileSource(resources = "/testdata.csv")
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
