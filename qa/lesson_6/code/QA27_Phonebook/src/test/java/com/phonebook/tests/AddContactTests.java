package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {

        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();

        app.getContact().fillAddContactForm(
                new Contact()
                        .setName("Karl")
                        .setLastname("Adam")
                        .setPhone("1234567890")
                        .setEmail("adam@gm.com")
                        .setAddress("Koblenz")
                        .setDescription("goalkeeper"));
        app.getContact().clickOnSaveButton();
        //assert by name of contact
        Assert.assertTrue(app.getContact().isContactCreatedByText("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}
