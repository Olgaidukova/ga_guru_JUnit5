import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AtlassianTestMethodSource {
    static Stream<Arguments> checkLocalesMenuButtons() {
        return Stream.of(Arguments.of("Italiano", List.of("Prodotti"+" "+"Per team"+" "+ "Assistenza")));
    }

    @ParameterizedTest(name = "Проверка отображения меню на {0}")
    @MethodSource
    void checkLocalesMenuButtons(String locale, List<String> buttons) {

        open("https://www.atlassian.com/");
        $(".language-selector-banner__language-selector").click();
        $$(".language-selector-banner__language-selector__options").find(text(locale)).click();
        $$(".global-nav--wac__links").filter(visible).
                shouldHave(texts(buttons));
    }
}

