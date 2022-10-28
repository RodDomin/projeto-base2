package base2.mantis.test.pageobjects;

import base2.mantis.test.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectProjectPage extends PageBase {
    public String URL = "https://mantis-prova.base2.com.br/login_select_proj_page.php?ref=bug_report_page.php";

    By submit = By.cssSelector("input[type=submit]");
    By selector = By.cssSelector("select");

    public void submit() {
        click(getElement(submit));
    }

    public void selectProjectByPosition(int index) {
        Select select = new Select(getElement(selector));

        select.selectByIndex(index);
    }

    public String getSelectedText() {
        Select select = new Select(getElement(selector));

        return select
                .getFirstSelectedOption()
                .getText();
    }
}
