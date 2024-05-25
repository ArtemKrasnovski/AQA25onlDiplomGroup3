package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.project.ProjectInfoPage;

import java.util.List;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";
    private final By addProjectSideButton = By.id("sidebar-projects-add");
    private final By projectsOnDashboard = By.xpath("//a[contains (@href, 'projects/overview')]");
    private final By copyToClipboardButton = By.xpath("//div[@tooltip-text='Copy to Clipboard']");
    private final By copyToClipboardHiddenText = By.xpath("//p[contains(text(), 'Copy to Clipboard')]");

    public DashboardPage(WebDriver driver, boolean isOpenedByUrl) {
        super(driver, isOpenedByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectSideButton;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getAddProjectSideButton() {
        return wait.waitForVisibility(addProjectSideButton);
    }

    public List<WebElement> getProjectInGrid() {
        return wait.waitForAllVisibleElementsLocatedBy(projectsOnDashboard);
    }

    public WebElement copyToClipboardButton() {
        return wait.waitForVisibility(copyToClipboardButton);
    }

    public WebElement copyToClipboardHiddenText() {
        return wait.waitForVisibility(copyToClipboardHiddenText);
    }

    public String showCopyToClipboardHiddenText() {
        return copyToClipboardHiddenText().getText();
    }

    public ProjectInfoPage clickOnProjectInGrid(Project project) {
        for (WebElement element :
                getProjectInGrid()) {
            if (element.getText().trim().equals(project.getName())) {
                element.click();

                return new ProjectInfoPage(driver, false);
            }
        }
        return null;
    }

    public String moveToElement() {
        Actions actions = new Actions(driver);

        actions
                .moveToElement(copyToClipboardButton())
                .build()
                .perform();

        return showCopyToClipboardHiddenText();
    }

}