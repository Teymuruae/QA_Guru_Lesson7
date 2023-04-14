package pages.components;

import com.codeborne.selenide.SelenideElement;
import enums.Months;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    private SelenideElement

            monthLocator = $(".react-datepicker__month-select"),
            yearLocator
                    = $(".react-datepicker__year-select"),
            dayLocator = $x("//div[@role = 'option' and text() = 20]");

    public void setDate(String day, Months month, String year){
        monthLocator.selectOption(month.toString());
        yearLocator.selectOption(year);
        $x(String.format("//div[ not(contains(@class, 'day--outside-month')) and @role = 'option' and text() = %s]",
                day)).click();

    }
}
