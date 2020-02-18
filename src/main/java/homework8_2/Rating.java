package homework8_2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Rating {


    public static void main(String[] args) {
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

        WebElement filterButton = driver.findElement(By.id("sortbar_dropdown_button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(filterButton).build().perform();
        filterButton.click();

        WebElement rating = driver.findElement(By.xpath("//*[@id=\"sortbar_dropdown_options\"]/li[2]/a"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(rating).build().perform();
        rating.click();

        WebElement firstHotel = driver.findElement(By.xpath("(.//div[@data-hotelid])[1]//a[@class='hotel_name_link url']"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(firstHotel).click(firstHotel).build().perform();

    }
}
