package steps;

import baseEntities.BaseSteps;
import models.Milestone;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.milestones.AddMilestonePage;
import pages.milestones.MilestonesOverviewPage;

public class MilestoneSteps extends BaseSteps {

    public MilestoneSteps(WebDriver driver) {
        super(driver);
    }

    public AddMilestonePage clickAddMilestoneButton() {
        projectInfoPage
                .getAddMilestoneToProject()
                .click();

        logger.info("Adding a milestone...");
        return new AddMilestonePage(driver);
    }

    public void fillMilestoneInfo(Milestone milestone) {
        addMilestonePage
                .enterMilestoneName(milestone)
                .enterMilestoneReference(milestone)
                .enterMilestoneDescription(milestone)
                .selectMilestoneCompetence(milestone)
                .clickAddMilestoneButton();
    }

    public MilestonesOverviewPage addMilestoneSuccessfully(Project project, Milestone milestone) {
        dashboardPage.clickOnProjectInGrid(project);

        clickAddMilestoneButton();
        fillMilestoneInfo(milestone);

        logger.info("Milestone added successfully!");
        return new MilestonesOverviewPage(driver);
    }

    public void fillMilestoneInfoWithFileUpload(Milestone milestone) {
        addMilestonePage
                .enterMilestoneName(milestone)
                .enterMilestoneReference(milestone)
                .enterMilestoneDescription(milestone)
                .selectMilestoneCompetence(milestone)
                .fileUploadInsideMilestone();
    }

    public AddMilestonePage uploadFileInsideMilestone(Project project, Milestone milestone) {
        dashboardPage.clickOnProjectInGrid(project);

        clickAddMilestoneButton();
        fillMilestoneInfoWithFileUpload(milestone);

        logger.info("File uploaded successfully!");
        return addMilestonePage;
    }
}
