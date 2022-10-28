package base2.mantis.test.tests;

import base2.mantis.test.bases.AuthenticatedTestBase;
import base2.mantis.test.flows.CreateIssueFlows;
import base2.mantis.test.flows.CreateIssueInfos;
import base2.mantis.test.pageobjects.CreateIssuePage;
import base2.mantis.test.pageobjects.ViewIssuePage;
import base2.mantis.test.utils.TextMockUtils;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CreateIssueTests extends AuthenticatedTestBase<CreateIssuePage> {
    private final CreateIssueFlows flows;

    public CreateIssueTests() {
        page = new CreateIssuePage();
        flows = new CreateIssueFlows(page);
    }

    @Override
    protected String pageUrl() {
        return page.URL;
    }

    @Test
    public void it_should_be_moved_to_see_issue_page_after_create() {
        CreateIssueInfos infos = new CreateIssueInfos();

        infos.setSummary(TextMockUtils.getWords(5));
        infos.setDescription(TextMockUtils.getParagraph());
        infos.setStepsToReproduce(TextMockUtils.getParagraph());
        infos.setAdditionalInformation(TextMockUtils.getParagraph());

        flows.confirmProjectSelection();
        flows.createIssue(infos);

        assertTrue(page.getCurrentUrl().contains(new ViewIssuePage().URL));
    }
}
