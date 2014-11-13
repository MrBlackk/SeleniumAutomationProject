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

    @Test(dependsOnMethods = {"openNotebooksPageAndVerifyNotebooksTab"})
    public void openAppleNotebooksPageAndChangeSorting(){
        notebooksPage.findAppleManufacturerAndClick();

        assertTrue(appleNotebooksPage.isOpened());

        appleNotebooksPage.selectSortExpensive();
    }

}
