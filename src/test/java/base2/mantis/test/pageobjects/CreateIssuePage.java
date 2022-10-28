package base2.mantis.test.pageobjects;

import base2.mantis.test.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateIssuePage extends PageBase {
    public String URL = "https://mantis-prova.base2.com.br/bug_report_page.php";

    private final By summary = By.cssSelector("input[id=summary]");
    private final By description = By.cssSelector("textarea[id=description]");
    private final By stepsToReproduce = By.cssSelector("textarea[id=steps_to_reproduce]");
    private final By additionalInfo = By.cssSelector("textarea[id=additional_info]");
    private final By submit = By.cssSelector("input[type=submit]");

    public void fillSummary(String data) {
        sendKeys(summary, data);
    }

    public void fillDescription(String data) {
        sendKeys(description, data);
    }

    public void fillStepsToReproduce(String data) {
        sendKeys(stepsToReproduce, data);
    }

    public void fillAdditionalInfo(String data) {
        sendKeys(additionalInfo, data);
    }

    public void submit() {
        click(getElement(submit));
    }

    public void waitUntilPageIsViewIssue() {
        WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(3));
        wait.until((driver) -> driver.getCurrentUrl().contains("view.php"));

    }
}
