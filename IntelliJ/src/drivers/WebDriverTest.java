package drivers;

public class WebDriverTest {
    public static void main(String[] args) {
        WebDriver driver = getDriver("fire1fox");
        driver.get();
        driver.findElementBy();
        driver.findElementBy();
        driver.findElementBy();
    }
        private static WebDriver getDriver (String name) {
            if (name.equals("chrome")) {
                return new ChromeDriver();
            } else if (name.equals("firefox")) {
                return new FirefoxDriver();
            }
            try {
                throw new NoValidBrowserName("No valid browser name");
            } catch ( NoValidBrowserName NoValidBrowserName) {
                NoValidBrowserName.printStackTrace();
            }
            return null;
        }
}
