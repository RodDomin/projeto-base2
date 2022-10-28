package base2.mantis.test.flows;

import base2.mantis.test.pageobjects.SelectProjectPage;

public class SelectProjectFlows {
    private final SelectProjectPage page;

    public SelectProjectFlows(SelectProjectPage page) {
        this.page = page;
    }

    public void goByDefaultSelected() {
        page.submit();
    }

    public void goByTestSelected() {
        page.selectProjectByPosition(1);
        page.submit();
    }
}
