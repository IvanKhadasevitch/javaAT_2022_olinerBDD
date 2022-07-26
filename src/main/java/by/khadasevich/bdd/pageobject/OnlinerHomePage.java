package by.khadasevich.bdd.pageobject;

import by.khadasevich.bdd.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.String.format;

public class OnlinerHomePage extends AbstractPage {
    private static final String ONLINER_URL = "https://www.onliner.by/";
    private static final String TEXT_PATTERN = "%s[contains(text(), '%s')]";
    private static final String MENU_SECTION =
            "//*[contains(@class, 'b-main-navigation')]";
    private static final String MENU_SUBSECTION_PATTERN =
        "//*[contains(@href, '%s.onliner') and contains(@href,'%s')]";

    public OnlinerHomePage() {
        PageFactory.initElements(getWebDriverDiscovery().getWebDriver(),
                this);
    }
    public void openOnLinerWebsite() {
        getWebDriverDiscovery().getWebDriver().get(ONLINER_URL);
    }

    public WebElement menuSection(final String linkText) {
        return findElement(By
                .xpath(format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }
    public void hoverMenuLinkWithText(final String linkText) {
        WebElement menuItem = menuSection(linkText);
        Actions action = new Actions(getWebDriverDiscovery().getWebDriver());
        action.moveToElement(menuItem).perform();
    }
    public List<WebElement> elementsSubMenuSectionWhereRefContains(
            final String signRefMenuSubSection, final String refContains) {
        return findElements(By.
                xpath(format(MENU_SUBSECTION_PATTERN,
                        signRefMenuSubSection, refContains)));
    }
}
