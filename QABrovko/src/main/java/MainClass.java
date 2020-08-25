import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {



        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\QABrovko\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //timeout

        //driver.manage().window().maximize(); //max window size
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://kulibin.com.ua/");

        //driver.navigate().to("https://kulibin.com.ua/");
        //driver.navigate().back();
        //driver.navigate().forward();
        //driver.navigate().refresh();

        System.out.println(driver.getTitle());                              //show title of page
        System.out.println(driver.getCurrentUrl());                         //show url of page


        WebElement link = driver.findElement(By.linkText("КАТАЛОГ ТОВАРОВ"));
        driver.findElement(By.cssSelector("a#catalog-menu"));


        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("Электроинструмент"))).perform();
        driver.findElement(By.cssSelector("li.li-hovered>div>div:nth-child(1)>ul>li:nth-child(3)>a")).click();


        int i;
        for(i=1; i<4; i++)
         {
             String[] myString = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
             int n = (int)Math.floor(Math.random() * myString.length);
             System.out.println(myString[n]);
             driver.findElement(By.cssSelector("li:nth-child("+n+")>div>h4>a>span")).click();

             if ((driver.findElement(By.cssSelector("div.price-row>span.item_old_price.old-price")).isDisplayed()) &&
                 (driver.findElement(By.cssSelector("div.item-print-block>div.price-row>span.price")).isDisplayed()))
             {
                 System.out.println("Ky"+"is discount");

             } else {
                 System.out.println("Hello"+" is not discount");
             }

             driver.navigate().back();
        }

        //driver.quit();
    }
}
