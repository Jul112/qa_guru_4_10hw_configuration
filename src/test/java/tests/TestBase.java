package tests;

import Configuration.TestConfig;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

//import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.attachScreenshot;

public class TestBase{
    static final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());
    @BeforeAll
    static void setup() {

        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.startMaximized = true;

        if (config.getRemoteDriverUrl()!=null) {
            Configuration.remote = config.getRemoteDriverUrl();
        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last Screenshot");
        /*attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video_storage")!=null) {
            attachVideo();
        }*/
    }
}