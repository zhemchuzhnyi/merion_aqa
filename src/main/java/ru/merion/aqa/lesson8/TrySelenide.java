package ru.merion.aqa.lesson8;
import com.codeborne.selenide.HighlightOptions;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

/*
        $("text"); // - css селектор findElement
        $x("//*"); // - по xpath
        $$("li"); // - findElements (S!)
*/

public class TrySelenide {
    public static void main(String[] args) {

        open("http://uitestingplayground.com/textinput");

        $(By.cssSelector("#newButtonName")).val("Welcome!");
        $(By.cssSelector("#newButtonName")).press(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP));
        $(By.cssSelector("#newButtonName")).press(Keys.BACK_SPACE);
        $(By.cssSelector("#newButtonName")).setValue("Selenide");
        $(By.cssSelector("#updatingButton")).click();

        $(By.cssSelector("#newButtonName")).highlight(HighlightOptions.background());

    }
}