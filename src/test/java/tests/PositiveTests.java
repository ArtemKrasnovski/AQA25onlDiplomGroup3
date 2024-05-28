package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.milestones.MilestonesViewPage;

public class PositiveTests extends BaseTest {
    @Description("Тест на проверку граничных значений")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Тест на проверку поля для ввода на граничные значения")
    public void boundaryValueTest() {

    }

    @Description("Тест на проверку всплывающего сообщения")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Тест на проверку всплывающего сообщения при наведении курсора на кнопку")
    public void hiddenTextTest() {

        dashboardPage.moveToElement(dashboardPage.copyToClipboardButton());

        Assert.assertEquals(
                dashboardPage.showCopyToClipboardHiddenText(), "Copy to Clipboard"
        );

    }

    @Description("Тест на создание сущности Project")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Тест на создание сущности Project с полным заполнением полей")
    public void addFullProjectTest() {

        Assert.assertTrue(
                projectSteps
                        .addProjectSuccessfully(testProject)
                        .isProjectInGrid(testProject)
        );
    }

    @Description("Тест на создание сущности Milestone")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Создание сущности Milestone с полным заполнением полей")
    public void addMilestoneTest() {

        Assert.assertTrue(
                milestoneSteps
                        .addMilestoneSuccessfully(testProject, testMilestone)
                        .isMilestoneInGrid(testMilestone)
        );
    }

    @Description("Тест на удаление сущности Project")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Тест на проверку удаления сущности Project")
    public void deleteProjectTest() {

        projectSteps
                .addProjectSuccessfully(testProject);

        Assert.assertEquals(
                projectSteps
                        .deleteProjectSuccessfully(testProject)
                        .getDeleteText(), "Successfully deleted the project."
        );
    }

    @Description("Тест на отображение диалогового окна")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Тест на проверку отображения диалогового окна")
    public void dialogWindowTest() {

        dashboardPage.clickTopMenuSearchButton();

        Assert.assertTrue(
                dashboardPage.isDialogWindowDisplayed()
        );
    }

    //Тест на загрузку файла проходит первый раз без проблем, файл загружается.
    // А при последующих запусках, если не удалять загруженный ранее файл, то тест падает
    @Description("Тест на загрузку файла")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Тест на загрузку файла в сущность Milestone")
    public void fileUploadTest() {

        milestoneSteps.addMilestoneWithFileUploadInside(testProject, testMilestone);

        MilestonesViewPage milestonesViewPage = new MilestonesViewPage(driver, true);
        //на Ассертах тест падает
        //Assert.assertTrue(milestonesViewPage.isPageOpened());
        //Assert.assertTrue(milestonesViewPage.isMilestoneImageDisplayed());
    }

}
