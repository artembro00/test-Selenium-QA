import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainClass2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\QABrovko\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //timeout

        driver.get("https://kulibin.com.ua/");

        System.out.println(driver.getTitle());                              //show title of page
        System.out.println(driver.getCurrentUrl());                         //show url of page

        WebElement link = driver.findElement(By.linkText("КАТАЛОГ ТОВАРОВ"));
        driver.findElement(By.cssSelector("a#catalog-menu"));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("Электроинструмент"))).perform();
        driver.findElement(By.cssSelector("li.li-hovered>div>div:nth-child(1)>ul>li:nth-child(12)>a")).click();

        for(int i=1; i<3; i++)
         {
             for(int j=1; j<16; j++) {
                 if (driver.findElement(By.cssSelector("li:nth-child(" + j + ")>div>div.text-box>div.text-left>div.wrap>span")).isDisplayed()) {
                     System.out.println( j + "is discount");
                 } else if (( driver.findElement(By.cssSelector("li:nth-child(" + j + ")>div>div.text-box>div.text-left>div.wrap>span.old-price")).isDisplayed()) &&
                         ( driver.findElement(By.cssSelector("li:nth-child(" + j + ")>div>div.text-box>div.text-left>div.wrap>span.price")).isDisplayed()))
                      {
                     System.out.println( j + " is not discount");
                 } else {
                     System.out.println("Ce bug");
                 }
             }
             driver.findElement(By.cssSelector("div.paging>a.next.btn-blue")).click();
        }
    }
}
