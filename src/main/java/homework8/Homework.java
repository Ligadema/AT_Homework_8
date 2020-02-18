package homework8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Homework {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sid-v\\Downloads\\chromedriver_win32\\chromedriver.exe");//your own path

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        driver.manage().window().fullscreen();
        WebElement city = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        city.sendKeys("Москва");
        city.submit();

        WebElement rooms = driver.findElement(By.id("no_rooms"));
        Select selectRooms = new Select(rooms);
        selectRooms.selectByValue("1");

        WebElement guests = driver.findElement(By.id("group_adults"));
        Select selectGuest = new Select(guests);
        selectGuest.selectByValue("2");

        WebElement hotels = driver.findElement(By.xpath("//*[@id=\"right\"]/div[5]"));
        String string = hotels.getText();
        System.out.println(string);
        Assert.assertTrue(!string.contains("(0)"), "Увы, вариантов нет: 0 объявлений");

    }
}
