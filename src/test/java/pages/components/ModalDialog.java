package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import testdata.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ModalDialog {

    private String textInModalWindow = "Thanks for submitting the form";
    private SelenideElement
            textToWaitForAfterSubmit = $(".modal-title"),
            modalDialog = $(".modal-dialog.modal-lg");

    public void verifyElements(String key, String value) {
        $x(String.format("//table//td[text() = '%s']//following-sibling::td", key)).shouldHave(Condition.text(value));
    }


    public void verifyModalAppear() {
        modalDialog.should(Condition.appear);
        textToWaitForAfterSubmit.shouldHave(Condition.text(textInModalWindow));


    }

}
