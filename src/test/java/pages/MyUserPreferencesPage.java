package pages;

import utilities.Log4Test;

/**
 * Created by c267 on 21.11.2014.
 */
public class MyUserPreferencesPage extends GeneralPage {

    public boolean isPageContainsCorrectEmailAndName(String email, String name){
        Log4Test.info("Verify  - Мои настройки page is opened,   Ваше имя and Электронная почтa are valid");
        return elementIsLocated(getLocator("namePreferences")).getText().contains(name) && elementIsLocated(getLocator("emailPreferences")).getText().contains(email);
    }
}
