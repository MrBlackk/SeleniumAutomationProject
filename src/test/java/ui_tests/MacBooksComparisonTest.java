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

        page.open(TestData.ROZETKA_URL);
        assertTrue(page.isOpened(TestData.ROZETKA_URL));
    }

    @Test(dependsOnMethods = {"setUpPreconditions"})
    public void openNotebooksPageAndVerifyNotebooksTab(){
        page.openNotebooksPage();
        assertTrue(notebooksPage.isOpened(TestData.NOTEBOOKS_PAGE_URL));

        assertTrue(notebooksPage.isTabActive());

        assertTrue(notebooksPage.verifyManufacturers());
    }

    @Test(dependsOnMethods = {"openNotebooksPageAndVerifyNotebooksTab"})
    public void openAppleNotebooksPageAndChangeSorting(){
        notebooksPage.findAppleManufacturerAndClick();

        assertTrue(appleNotebooksPage.isOpened(TestData.APPLE_NOTEBOOKS_PAGE_URL));

        appleNotebooksPage.selectSortExpensive();

    }

    @Test(dependsOnMethods = {"openAppleNotebooksPageAndChangeSorting"})
    public void selectCompareCheckboxAndCheckList() throws InterruptedException {
        appleNotebooksPage.isMacBookPresentAndSelectChecbox(TestData.MAC_BOOK_PRO_RETINA_15_CODE);

        assertTrue(appleNotebooksPage.isComparisonListShown());
        assertTrue(appleNotebooksPage.isMacBooksInComparisonList(TestData.MAC_BOOK_PRO_RETINA_15_CODE));

        appleNotebooksPage.isMacBookPresentAndSelectChecbox(TestData.MAC_BOOK_AIR_11_CODE);

        //assertTrue(appleNotebooksPage.isComparisonListShown());
        assertTrue(appleNotebooksPage.isMacBooksInComparisonList(TestData.MAC_BOOK_AIR_11_CODE));
    }

    @Test(dependsOnMethods = {"selectCompareCheckboxAndCheckList"})
    public void openComparisonPageAndVerify(){
        appleNotebooksPage.clickCompare();

        assertTrue(comparisonPage.isOpened(TestData.COMPARISON_PAGE_URL));

        assertTrue(comparisonPage.isCompareGoodsTextPresent());

        assertTrue(comparisonPage.isMacBooksPresent(TestData.MAC_BOOK_PRO_RETINA_15_CODE));
        assertTrue(comparisonPage.isMacBooksPresent(TestData.MAC_BOOK_AIR_11_CODE));
    }


}
