import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class FormTest {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        driver = new FirefoxDriver(); // runs in a new thread
    }

    @Test
    public void validInputAllFields() {
        WebElement first_name, last_name, email, telephone, btn_submit, comments;

        driver.navigate().to("http://www.webdriverguru.com/form.html");

        first_name = driver.findElement(By.name("first_name"));
        last_name = driver.findElement(By.name("last_name"));
        email = driver.findElement(By.name("email"));
        telephone = driver.findElement(By.name("telephone"));
        btn_submit = driver.findElement(By.cssSelector("input[type=submit][value=Submit]"));
        comments = driver.findElement(By.cssSelector("textarea"));

        first_name.sendKeys("Yulia");
        last_name.sendKeys("Falls");
        email.sendKeys("yuliafalls@gmail.com");
        telephone.sendKeys("650 339-2761");
        comments.sendKeys("my comments");
        btn_submit.click();

        assertTrue(driver.getPageSource().contains("Thank you for contacting us"));
    }

    @Test
    public void phoneNumberIsOptional() {
        WebElement first_name, last_name, email, btn_submit, comments;

        driver.navigate().to("http://www.webdriverguru.com/form.html");

        first_name = driver.findElement(By.name("first_name"));
        last_name = driver.findElement(By.name("last_name"));
        email = driver.findElement(By.name("email"));
        btn_submit = driver.findElement(By.cssSelector("input[type=submit][value=Submit]"));
        comments = driver.findElement(By.cssSelector("textarea"));

        first_name.sendKeys("Yulia");
        last_name.sendKeys("Falls");
        email.sendKeys("yuliafalls@gmail.com");
        comments.sendKeys("my comments");
        btn_submit.click();

        assertTrue(driver.getPageSource().contains("Thank you for contacting us"));
    }

    @Test
    public void invalidFirstName() {
        WebElement first_name, last_name, email, btn_submit, comments;

        driver.navigate().to("http://www.webdriverguru.com/form.html");

        first_name = driver.findElement(By.name("first_name"));
        last_name = driver.findElement(By.name("last_name"));
        email = driver.findElement(By.name("email"));
        btn_submit = driver.findElement(By.cssSelector("input[type=submit][value=Submit]"));
        comments = driver.findElement(By.cssSelector("textarea"));

        first_name.sendKeys("Yulia123");
        last_name.sendKeys("Falls");
        email.sendKeys("yuliafalls@gmail.com");
        comments.sendKeys("my comments");
        btn_submit.click();

        assertTrue(driver.getPageSource().contains("The First Name you entered does not appear to be valid"));
    }

    @Test
    public void invalidLastName() {
        WebElement first_name, last_name, email, btn_submit, comments;

        driver.navigate().to("http://www.webdriverguru.com/form.html");

        first_name = driver.findElement(By.name("first_name"));
        last_name = driver.findElement(By.name("last_name"));
        email = driver.findElement(By.name("email"));
        btn_submit = driver.findElement(By.cssSelector("input[type=submit][value=Submit]"));
        comments = driver.findElement(By.cssSelector("textarea"));

        first_name.sendKeys("Yulia");
        last_name.sendKeys("Falls456");
        email.sendKeys("yuliafalls@gmail.com");
        comments.sendKeys("my comments");
        btn_submit.click();

        assertTrue(driver.getPageSource().contains("The Last Name you entered does not appear to be valid"));
    }

    @Test
    public void invalidEmail() {
        WebElement first_name, last_name, email, btn_submit, comments;

        driver.navigate().to("http://www.webdriverguru.com/form.html");

        first_name = driver.findElement(By.name("first_name"));
        last_name = driver.findElement(By.name("last_name"));
        email = driver.findElement(By.name("email"));
        btn_submit = driver.findElement(By.cssSelector("input[type=submit][value=Submit]"));
        comments = driver.findElement(By.cssSelector("textarea"));

        first_name.sendKeys("Yulia");
        last_name.sendKeys("Falls456");
        email.sendKeys("yuliafalls@gmail");
        comments.sendKeys("my comments");
        btn_submit.click();

        assertTrue(driver.getPageSource().contains("The Email Address you entered does not appear to be valid"));
    }

    @Test
    public void invalidFirstNameLastNameEmail() {
        WebElement first_name, last_name, email, btn_submit, comments;

        driver.navigate().to("http://www.webdriverguru.com/form.html");

        btn_submit = driver.findElement(By.cssSelector("input[type=submit][value=Submit]"));
        comments = driver.findElement(By.cssSelector("textarea"));

        comments.sendKeys("my comments");
        btn_submit.click();

        assertTrue(driver.getPageSource().contains("The First Name you entered does not appear to be valid"));
        assertTrue(driver.getPageSource().contains("The Last Name you entered does not appear to be valid"));
        assertTrue(driver.getPageSource().contains("The Email Address you entered does not appear to be valid"));
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }
}
