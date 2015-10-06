import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercicio3 {

    WebDriver driver;

    @Before
    public void tearUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        //Acessa o formulário indicado abaixo
        driver.get("https://docs.google.com/forms/d/1M-TceJTer1N81ov46JsdkxXN62nMiSCU5TScgCzSCNI/viewform?c=0&w=1");
        //Procura elemento com id especificada abaixo e escreve o termo no mesmo
        driver.findElement(By.id("entry_1050252143")).sendKeys("Marlon Almeida");
        //Instancia um select, procura elemento com a id especificada e selesuciona a o elemento com value especificado
        new Select(driver.findElement(By.id("entry_2043435478"))).selectByValue("Python");
        //Procura outros elementos com as id's espeficicadas abaixo e clica em cada um
        driver.findElement(By.id("group_1094861216_1")).click();
        driver.findElement(By.id("group_1880671481_1")).click();
        driver.findElement(By.id("group_1880671481_2")).click();
        //Finaliza o preenchimento do form realizando a ação de submit
        driver.findElement(By.name("submit")).submit();
    }

    @Test
    public void testarValidacoes() {
        //Acessa o formulário indicado abaixo
        driver.get("https://docs.google.com/forms/d/1M-TceJTer1N81ov46JsdkxXN62nMiSCU5TScgCzSCNI/viewform?c=0&w=1");
        //Tenta submeter o formulário vazio
        driver.findElement(By.name("submit")).submit();
        //Afirma se o texto especificado abaixo aparece no elemento com classe que destaca aviso de obrigatoriedade
        assertThat(driver.findElement(By.className("ss-required-asterisk")).getText(),containsString("*Obrigatório"));
    }
}