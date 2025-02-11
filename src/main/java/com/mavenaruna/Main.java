package main.java.com.mavenaruna;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        WebDriver driver = new ChromeDriver();
        driver.get("https:\\www.google.com");
        try {
            driver.switchTo().alert();  
        } catch (NoAlertPresentException e) {
        }
        catch(NoSuchFrameException f){

        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
}