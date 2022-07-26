package by.khadasevich.bdd.framework;

import java.util.Arrays;

public enum Driver {
    CHROME("chrome", new ChromeDriverCreator()),
    GECKO("gecko", new FirefoxDriverCreator());
    private final String driverType;
    private WebDriverCreator webDriverCreator;
    Driver(final String driverType,
           final WebDriverCreator webDriverCreator) {
        this.driverType = driverType;
        this.webDriverCreator = webDriverCreator;
    }
    public String getDriverType() {
        return driverType;
    }

    public WebDriverCreator getWebDriverCreator() {
        return webDriverCreator;
    }

    public static Driver getByDriverType(String driverType) {
        return Arrays.stream(Driver.values())
                .filter(driver -> driver.getDriverType().equals(driverType))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Driver type'"
                        + driverType + "' is not specified in Driver enum"));
    }
}
