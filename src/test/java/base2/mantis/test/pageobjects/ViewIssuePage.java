package base2.mantis.test.pageobjects;

import base2.mantis.test.bases.PageBase;
import org.openqa.selenium.By;

public class ViewIssuePage extends PageBase {
    public String URL = "https://mantis-prova.base2.com.br/view.php?id=";

    private final By project = By.cssSelector("td.bug-project");

    public String getProject() {
        return getText(getElement(project));
    }
}
