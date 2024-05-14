package org.example;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {
    private WebDriver driver;

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().window().maximize(); // функция для управления браузером эта разворачивает окно на весь экран
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));

        driver.get("https://google.com"); //Открывает урл

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //ждем пока найдем элемент  из следю строки
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).click();

        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("java");
        driver.findElement(By.xpath("//input[@class='gNO89b' and @role='button' and @aria-label= 'Поиск в Google']")).click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @After
    public void end(){
        driver.quit();
    }
}
