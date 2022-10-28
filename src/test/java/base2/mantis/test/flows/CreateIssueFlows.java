package base2.mantis.test.flows;

import base2.mantis.test.pageobjects.CreateIssuePage;
import base2.mantis.test.pageobjects.SelectProjectPage;

public class CreateIssueFlows {
    private final CreateIssuePage page;
    private final SelectProjectPage selectProjectPage;

    public CreateIssueFlows(CreateIssuePage page) {
        this.page = page;
        this.selectProjectPage = new SelectProjectPage();
    }

    public void confirmProjectSelection() {
        page.navigateTo(selectProjectPage.URL);

        selectProjectPage.submit();
    }

    public void createIssue(CreateIssueInfos infos) {
        page.fillSummary(infos.getSummary());
        page.fillDescription(infos.getDescription());
        page.fillStepsToReproduce(infos.getStepsToReproduce());
        page.fillAdditionalInfo(infos.getAdditionalInformation());

        page.submit();

        page.waitUntilPageIsViewIssue();
    }

}
