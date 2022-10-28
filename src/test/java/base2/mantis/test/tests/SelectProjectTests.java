package base2.mantis.test.tests;

import base2.mantis.test.bases.AuthenticatedTestBase;
import base2.mantis.test.flows.CreateIssueFlows;
import base2.mantis.test.flows.CreateIssueInfos;
import base2.mantis.test.flows.SelectProjectFlows;
import base2.mantis.test.pageobjects.CreateIssuePage;
import base2.mantis.test.pageobjects.SelectProjectPage;
import static org.junit.jupiter.api.Assertions.*;

import base2.mantis.test.pageobjects.ViewIssuePage;
import base2.mantis.test.utils.TextMockUtils;
import org.junit.jupiter.api.Test;

public class SelectProjectTests extends AuthenticatedTestBase<SelectProjectPage> {
    private final SelectProjectFlows flows;
    private final CreateIssueFlows createIssueFlow;
    private final ViewIssuePage viewIssuePage;

    public SelectProjectTests() {
        page = new SelectProjectPage();
        flows = new SelectProjectFlows(page);
        createIssueFlow = new CreateIssueFlows(new CreateIssuePage());

        viewIssuePage = new ViewIssuePage();
    }

    @Override
    protected String pageUrl() {
        return page.URL;
    }

    @Test
    public void it_should_move_to_create_issue_page_with_selected_project() {
        flows.goByDefaultSelected();

        CreateIssueInfos infos = new CreateIssueInfos();

        infos.setSummary(TextMockUtils.getWords(5));
        infos.setDescription(TextMockUtils.getParagraph());
        infos.setStepsToReproduce(TextMockUtils.getParagraph());
        infos.setAdditionalInformation(TextMockUtils.getParagraph());

        createIssueFlow.createIssue(infos);

        assertTrue(viewIssuePage.getProject().contains("Joice Nascimento's Project"));
    }

    @Test
    public void it_should_move_to_create_issue_page_with_test_selected_project() {
        flows.goByTestSelected();

        CreateIssueInfos infos = new CreateIssueInfos();

        infos.setSummary(TextMockUtils.getWords(5));
        infos.setDescription(TextMockUtils.getParagraph());
        infos.setStepsToReproduce(TextMockUtils.getParagraph());
        infos.setAdditionalInformation(TextMockUtils.getParagraph());

        createIssueFlow.createIssue(infos);

        assertTrue(viewIssuePage.getProject().contains("Teste"));
    }
}
