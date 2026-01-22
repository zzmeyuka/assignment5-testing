import org.example.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class) // Подключаем наш отчет и скриншоты
public class SauceDemoTests extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() {
        logger.info("Тест 1: Валидный логин");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());
        logger.info("Тест 1 пройден.");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        logger.info("Тест 2: Невалидный логин (ожидаем ошибку)");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
        driver.findElement(By.id("login-button")).click();

        String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertTrue(error.contains("Epic sadface"), "Сообщение об ошибке не появилось!");
        logger.info("Тест 2 пройден.");
    }

    @Test(priority = 3)
    public void failedTestForScreenshot() {
        logger.info("Тест 3: Специально роняем тест для проверки скриншота");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Специально ищем несуществующий элемент, чтобы тест упал
        boolean isVisible = driver.findElement(By.id("NON_EXISTENT_ELEMENT")).isDisplayed();
        Assert.assertTrue(isVisible);
    }
}