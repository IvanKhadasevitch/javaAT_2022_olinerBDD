package by.khadasevich.bdd.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class WebDriverDiscovery {
    private static final int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 15;
    private static final int PAGE_LOAD_TIMEOUT = 15;
    private static final ThreadLocal<RemoteWebDriver> remoteWebDriver =
            new ThreadLocal<>();

    public WebDriverDiscovery() {
        if (remoteWebDriver.get() == null) {
            startBrowser();
        }
    }
    private void startBrowser() {
        setWebDriver(Driver.getByDriverType(System.getProperty("driverType"))
                .getWebDriverCreator()
                .create());
    }
    private static void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration
                        .ofSeconds(DEFAULT_IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        // shut down hook to finish work once after all methods are done
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit(); remoteWebDriver.remove();
                    System.out.println("Driver shut down");
                })
        );
    }
    public WebDriver getWebDriver() {
        return remoteWebDriver.get();
    }
}
