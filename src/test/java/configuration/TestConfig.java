package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                 "classpath:local.properties",
                 "classpath:${environment}.properties"
                 })
public interface TestConfig extends Config {

    @Key("remote.url")
    String getRemoteDriverUrl();

    @Key("browser.name")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();
}
