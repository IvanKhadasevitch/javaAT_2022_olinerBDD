package by.khadasevich.bdd.steps;

import by.khadasevich.bdd.pageobject.OnlinerHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static java.lang.String.format;

import java.util.List;

public class MenuSteps {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
    @Given("the user opens Onliner website")
    public void theUserOpensOnlinerWebsite() {
        onlinerHomePage.openOnLinerWebsite();
    }

    @When("the user hover over the {string} menu item")
    public void theUserHoverOverTheMenuItem(String item) {
        onlinerHomePage.hoverMenuLinkWithText(item);
    }

    @Then("menu item has {string} submenu with {string} section")
    public void menuItemHasSubmenuWithSection(String signSubMenuRef,
                                              String section) {
        List<WebElement> priceSubMenu =
                onlinerHomePage
                        .elementsSubMenuSectionWhereRefContains(signSubMenuRef,
                                section);
        assertThat(priceSubMenu)
                .as(format("%s submenu section doesn't exist", section))
                .isNotEmpty();
    }
}
