package pages.milestones;

import baseEntities.BasePage;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddMilestonePage extends BasePage {
    private final By milestoneNameInput = By.id("name");
    private final By milestoneReferenceInput = By.id("reference");
    private final By milestoneDescriptionInputLocator = By.id("description_display");
    private final By milestoneIsCompletedCheckbox = By.id("is_completed");
    private final By addMilestoneButton = By.id("accept");
    private final By uploadFileInsideMilestone = By.id("entityAttachmentListEmptyIcon");
    private final By attachFileAddButton = By.id("libraryAddAttachment");
    private final By submitAttachButton = By.id("attachmentNewSubmit");


    public AddMilestonePage(WebDriver driver, boolean isOpenedByUrl) {
        super(driver, isOpenedByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return milestoneNameInput;
    }

    @Override
    protected String getPagePath() {
        return null;
    }

    public WebElement getMilestoneName() {
        return wait.waitForVisibility(milestoneNameInput);
    }

    public AddMilestonePage enterMilestoneName(Milestone milestone) {
        getMilestoneName().sendKeys(milestone.getName());
        return this;
    }

    public WebElement getMilestoneReference() {
        return wait.waitForVisibility(milestoneReferenceInput);
    }

    public AddMilestonePage enterMilestoneReference(Milestone milestone) {
        getMilestoneReference().sendKeys(milestone.getReference());
        return this;
    }

    public WebElement getMilestoneDescription() {
        return wait.waitForVisibility(milestoneDescriptionInputLocator);
    }

    public AddMilestonePage enterMilestoneDescription(Milestone milestone) {
        getMilestoneDescription().sendKeys(milestone.getDescription());
        return this;
    }

    public WebElement getMilestoneCompetence() {
        return wait.waitForVisibility(milestoneIsCompletedCheckbox);
    }

    public AddMilestonePage selectMilestoneCompetence(Milestone milestone) {
        if (milestone.isCompleted()) {
            getMilestoneCompetence().click();
        }
        return this;
    }

    public WebElement getMilestoneAddButton() {
        return wait.waitForVisibility(addMilestoneButton);
    }

    public WebElement getUploadFileInsideMilestone() {
        return wait.waitForVisibility(uploadFileInsideMilestone);
    }

    public WebElement getAttachFileAddButton() {
        return wait.waitForVisibility(attachFileAddButton);
    }

    public WebElement getSubmitAttachButton() {
        return wait.waitForVisibility(submitAttachButton);
    }

    public void clickUploadFileInsideMilestoneButton() {
        getUploadFileInsideMilestone().click();
    }

    public void clickAttachFileAddButton() {
        getAttachFileAddButton().click();
    }

    public void clickSubmitAttachButton() {
        getSubmitAttachButton().click();
    }


    public void clickAddMilestoneButton() {
        getMilestoneAddButton().click();
    }

    public void fillMilestoneInfo(Milestone milestone) {
        this
                .enterMilestoneName(milestone)
                .enterMilestoneReference(milestone)
                .enterMilestoneDescription(milestone)
                .selectMilestoneCompetence(milestone)
                .clickAddMilestoneButton();
    }

    public void fillMilestoneInfoWithFileUpload(Milestone milestone) {
        this
                .enterMilestoneName(milestone)
                .enterMilestoneReference(milestone)
                .enterMilestoneDescription(milestone)
                .selectMilestoneCompetence(milestone)
                .fileUploadInsideMilestone()
                .clickAddMilestoneButton();
    }

    public AddMilestonePage fileUploadInsideMilestone() {

        clickUploadFileInsideMilestoneButton();
        clickAttachFileAddButton();

        String path = AddMilestonePage.class
                .getClassLoader()
                .getResource("Screenshot 2024-05-17 181529.png")
                .getPath().substring(1);

        getAttachFileAddButton().sendKeys(path);

        clickSubmitAttachButton();

        return this;
    }



}