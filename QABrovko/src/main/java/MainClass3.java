import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainClass3 {

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
        driver.findElement(By.cssSelector("div:nth-child(1)>ul>li:nth-child(24)>a")).click();


        int i;
        int j;

        for(i=1; i<4; i++)
         {
             for(j=1; j<16; j++) {
                 if (driver.findElement(By.cssSelector("li:nth-child(" + j + ")>div>div.image>div.item-brand-country>img[src='/upload/resize_cache/iblock/0f5/30_20_1/United_states.jpg']")).isDisplayed()) {
                     System.out.println( j + "is discount");
                 } else {
                     System.out.println(j);
                 }
             }


             driver.findElement(By.cssSelector("div.paging>a.next.btn-blue")).click();
        }
    }
}
//#bx_2040626179_6497>div.image.items_list_image_wrap_6497>div.item-brand-country>img