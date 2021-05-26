package BrowserTests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserScreenShotTests {

  private WebDriver driver;

  @BeforeMethod
  public void newDriver() throws MalformedURLException {

    final DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setBrowserName(BrowserType.CHROME);
    caps.setPlatform(Platform.ANY);
    caps.setCapability("enableVideo", true);
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
  }

  @Test
  public void shouldOpenBrowser() throws IOException {
    driver.get("https://github.com/wooooooolf");
    Screenshot screenshot = new AShot().takeScreenshot(driver);
    ImageIO.write(screenshot.getImage(), "png", new File("C:/Users/Ura/IdeaProjects/github-sample/src/test/resources"));
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}