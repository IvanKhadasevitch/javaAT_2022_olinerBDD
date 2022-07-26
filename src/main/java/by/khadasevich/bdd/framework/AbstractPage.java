package by.khadasevich.bdd.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractPage {
    private final WebDriver driver;
    private final WebDriverDiscovery webDriverDiscovery;

    protected AbstractPage() {
        webDriverDiscovery = new WebDriverDiscovery();
        driver = webDriverDiscovery.getWebDriver();
    }
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebDriverDiscovery getWebDriverDiscovery() {
        return webDriverDiscovery;
    }
}
