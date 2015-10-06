import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercicio5 {

    WebDriver driver;

    @Before
    public void tearUp() {
        driver = new FirefoxDriver();
    }

    //@After
    //public void tearDown() { driver.close(); }

    @Test
    public void test() {
        //Endereço do host
        driver.get("http://10.72.124.151:3000");
        //Procura link com texto especificado abaixo e clica
        driver.findElement(By.linkText("Log in")).click();
        //Procura elemento com id indicado abaixo e escreve o login
        driver.findElement(By.id("login")).sendKeys("rafalima");
        //Procura elemento com id indicado abaixo e escreve a senha
        driver.findElement(By.id("password")).sendKeys("password");
        //Procura o elemento com name indicado abaixo e clica
        driver.findElement(By.name("commit")).click();
        //Procura link com texto especificado abaixo e clica
        driver.findElement(By.linkText("Administration interface")).click();
        //Procura link com texto especificado abaixo e clica
        driver.findElement(By.linkText("Customers")).click();
        //Procura elemento com id indicado abaixo e escreve o texto
        driver.findElement(By.id("q_username")).sendKeys("rafalima");
        //Procura elemento com name especificado abaixo e clica
        driver.findElement(By.name("commit")).click();
        //Afirma se o elemento com classe de nome indicada abaixo combina com o texto seguinte afim de afirmar
        //que foi encontrado apenas 1 cliente no resultado da busca
        assertThat(driver.findElement(By.className("pagination_information")).getText(),
                containsString("Displaying 1 Customer"));
        //Procura a tabela de resultados pelo id, dentro da mesma, procura a tag indicada abaixo e em seguida o elemento
        //com classe de nome especificada para afirmar se cliente tem o login descrito abaixo
        assertThat(driver.findElement(By.id("index_table_customers")).findElement(By.tagName("tbody")).findElement(By.className("col-username")).getText(),
                containsString("rafalima"));
    }
}