package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    // Создаем логгер, который будет писать в файл logs/test_run.log
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        logger.info("--- ЗАПУСК ТЕСТА: Открытие браузера Chrome ---");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
        logger.info("Открыта страница: " + driver.getCurrentUrl());
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("--- ЗАВЕРШЕНИЕ ТЕСТА: Закрытие браузера ---");
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}