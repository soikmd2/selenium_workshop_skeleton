import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercicio2 {

    WebDriver driver;

    @Before
    public void tearUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        //Acessa www.google.com
        driver.get("http://www.google.com");
        //Procura o campo de busca e digita o termo especificado abaixo
        driver.findElement(By.id("lst-ib")).sendKeys("selenium");
        //Procura um link com texto especificado abaixo e clica no mesmo
        driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
        //Afirma que o elemento com id especificado abaixo possui texto que contém o termo especificado abaixo
        assertThat(driver.findElement(By.id("mainContent")).getText(),containsString("What is Selenium?"));
    }
}