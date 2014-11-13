package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.AppleNotebooksPage;
import pages.ComparisonPage;
import pages.NotebooksPage;
import pages.RozetkaWelcomePage;

import static org.testng.Assert.*;

/**
 * Created by chv on 12.11.2014.
 */
public class MacBooksComparisonTest extends TestBase {

    RozetkaWelcomePage page = new RozetkaWelcomePage();
    NotebooksPage notebooksPage = new NotebooksPage();
    AppleNotebooksPage appleNotebooksPage = new AppleNotebooksPage();
    ComparisonPage comparisonPage = new ComparisonPage();

    @Test
    public void setUpPreconditions(){

        page.open();
        assertTrue(page.isOpened());
    }

    @Test(dependsOnMethods = {"setUpPreconditions"})
    public void openNotebooksPageAndVerifyNotebooksTab(){
        page.openNotebooksPage();
        assertTrue(notebooksPage.isOpened());

        assertTrue(notebooksPage.isTabActive());

        assertTrue(notebooksPage.verifyManufacturers());



    }
    private String macBookProRetina = "Z0PU002JE";
    private String macBookAir = "MD712UA/A";

    @Test(dependsOnMethods = {"openNotebooksPageAndVerifyNotebooksTab"})
    public void openAppleNotebooksPageAndChangeSorting(){
        notebooksPage.findAppleManufacturerAndClick();

        assertTrue(appleNotebooksPage.isOpened());

        appleNotebooksPage.selectSortExpensive();

    }

    @Test(dependsOnMethods = {"openAppleNotebooksPageAndChangeSorting"})
    public void selectCompareCheckboxAndCheckList() throws InterruptedException {
        appleNotebooksPage.isMacBookPresentAndSelectChecbox(macBookProRetina);

        assertTrue(appleNotebooksPage.isComparisonListShown());

        //appleNotebooksPage.isMacBooksInComparisonList(macBookProRetina);

        assertTrue(appleNotebooksPage.isMacBooksInComparisonList(macBookProRetina));

        appleNotebooksPage.isMacBookPresentAndSelectChecbox(macBookAir);
        assertTrue(appleNotebooksPage.isMacBooksInComparisonList(macBookAir));



    }

    @Test(dependsOnMethods = {"selectCompareCheckboxAndCheckList"})
    public void openComparisonPageAndVerify(){
        appleNotebooksPage.clickCompare();

        assertTrue(comparisonPage.isOpened());

        assertTrue(comparisonPage.isCompareGoodsTextPresent());

        assertTrue(comparisonPage.isMacBooksPresent(macBookProRetina));
        assertTrue(comparisonPage.isMacBooksPresent(macBookAir));
    }


}
