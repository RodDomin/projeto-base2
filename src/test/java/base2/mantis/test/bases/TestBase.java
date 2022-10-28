package base2.mantis.test.bases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase<T extends PageBase> {
	protected T page;
	
	protected abstract String pageUrl();
	
	@BeforeEach()
	public void initialize() {
		page.open(pageUrl());
	}

	@AfterEach()
	public void close() {
		page.close();
	}
}
