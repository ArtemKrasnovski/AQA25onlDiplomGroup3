package pages.milestones;

import baseEntities.BasePage;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MilestonesOverviewPage extends BasePage {

    private final By milestonesHeader = By.className("content-header-title");
    private final By milestonesList = By.className("summary-title");

    public MilestonesOverviewPage(WebDriver driver, boolean isOpenedByUrl) {
        super(driver, isOpenedByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return milestonesHeader;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    // нужен ли тут getMilestonesHeader если он нигде не используется?
    public WebElement getMilestonesHeader() {
        return wait.waitForVisibility(milestonesHeader);
    }

    // не уверен в правильности  return (List<WebElement>) wait.waitForVisibility(milestonesList);
    public List<WebElement> getMilestonesList() {
        return (List<WebElement>) wait.waitForVisibility(milestonesList);
    }

    public boolean isMilestoneInGrid(Milestone milestone) {
        for (WebElement element :
                getMilestonesList()) {
            if (element.getText().trim().equals(milestone.getName())) {
                return true;
            }
        }
        return false;
    }
}