package Configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${source}.properties")
public interface TestConfig extends Config {

    @Key("remote.url")
    String getRemoteDriverUrl();

    @Key("browser.name")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();
}
