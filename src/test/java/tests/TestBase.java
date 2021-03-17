package tests;

import com.codeborne.selenide.Configuration;
import configuration.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static helpers.AttachmentsHelper.*;

public class TestBase {

    @BeforeAll
    static void setup() {
        final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.startMaximized = true;

//       if (config.getRemoteDriverUrl()!=null) {
//            Configuration.remote = config.getRemoteDriverUrl();
//        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last Screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video_storage")!=null) {
            attachVideo();
        }
    }
}