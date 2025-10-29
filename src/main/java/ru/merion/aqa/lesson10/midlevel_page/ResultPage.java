package ru.merion.aqa.lesson10.midlevel_page;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    public void addAllItemsToCart() {
        $$(".product-card:has(.buy-link)").forEach(button -> button.click());

    }

}
