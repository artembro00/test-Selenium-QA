import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainClass4 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\QABrovko\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   //timeout

        driver.get("https://kulibin.com.ua/");


        System.out.println(driver.getTitle());                              //show title of page
        System.out.println(driver.getCurrentUrl());                         //show url of page

        WebElement link = driver.findElement(By.linkText("КАТАЛОГ ТОВАРОВ"));
        driver.findElement(By.cssSelector("a#catalog-menu"));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("Электроинструмент"))).perform();
        driver.findElement(By.cssSelector("li.li-hovered>div>div:nth-child(1)>ul>li:nth-child(1)>a")).click();

       /* driver.findElement(By.cssSelector("div.btn-group.bootstrap-select.sort-select>button")).click();
        driver.findElement(By.cssSelector("div.btn-group.bootstrap-select.sort-select.open>div>ul>li:nth-child(3)>a>span.text")).click();*/
             for (int j=4; j<15; j++) {

                 //String[] myString = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
                 //int n = (int)Math.floor((Math.random() * 14)+1);
                 System.out.println(j);



                  //driver.findElement(By.cssSelector("div.col-xs-9>ul>li:nth-child("+n+")>div>div.image>a>img")).isDisplayed()

                 if ((driver.findElement(By.cssSelector("li:nth-child("+j+")>div>div.text-box>div.text-left>div.wrap>span.old-price")).isDisplayed()) &&
                         (driver.findElement(By.cssSelector("li:nth-child("+j+")>div>div.image>div.stick-list>div:nth-child(1)>span")).isDisplayed())) {

                     System.out.println( driver.getTitle() + "is discount");

                     String discount = driver.findElement(By.cssSelector("li:nth-child("+j+")>div>div.image>div.stick-list>div:nth-child(1)>span")).getText();
                     System.out.println( discount + "is discount");


                     int start1 = 1;
                     int end1 = 3;
                     char[] dst = new char[end1 - start1];
                     discount.getChars(start1, end1, dst, 0);
                     System.out.println(dst);

                     double a=Integer.parseInt(String.valueOf(dst));
                     System.out.println(a);
                     int y;
                   //  y = a*2;
               // System.out.println(y);

                     String price = driver.findElement(By.cssSelector("li:nth-child("+j+")>div>div.text-box>div.text-left>div.wrap>span.price")).getText();
                     System.out.println( price + "pricet");

                     int start2 = 0;
                     int end2 = 6;
                     char[] dst2 = new char[end2 - start2];
                     price.getChars(start2, end2, dst2, 0);
                     System.out.println(dst2);

                    String o = String.valueOf(dst2);
                    String p = o.replaceAll(" ","");

                     int a2=Integer.parseInt(p);
                     System.out.println(a2*2);

                     String price3 = driver.findElement(By.cssSelector("li:nth-child("+j+")>div>div.text-box>div.text-left>div.wrap>span.old-price")).getText();
                     System.out.println( price3 + "pricet");

                     int start3 = 0;
                     int end3 = 6;
                     char[] dst3 = new char[end3 - start3];
                     price3.getChars(start3, end3, dst3, 0);
                     System.out.println(dst3);

                     String o3 = String.valueOf(dst3);
                     String p3 = o3.replaceAll(" ","");

                     int a3=Integer.parseInt(p3);
                     System.out.println(a3*2);

                     System.out.println("chisla"+" " +a2 + " "+a3+" " + a  );


                      double u = ((a3)-(a3*(a/100))) ;
                      int k = (int) Math.round(u);
                     System.out.println(k);
                   //  System.out.println(int n = ((a3)-(a3*(a/100))));

                     if (a2 == k) {
                         System.out.println("vseok");
                     }
                     else {
                         System.out.println("nevseok");
                     }

                     /*String price2 = driver.findElement(By.cssSelector("li:nth-child("+j+")>div>div.text-box>div.text-left>div.wrap>span.price")).getText();
                     System.out.println( price2 + "pricet");
*/
                     /*int start21 = 2;
                     int end21 = 5;
                     char[] dst21 = new char[end21 - start21];
                     price2.getChars(start21, end21, dst21, 0);
                     System.out.println(dst21);
                     int a21=Integer.parseInt(String.valueOf(dst21));
                     System.out.println(a21);


                  int h = (a2*1000)+a21;
                     System.out.println(h);*/

                     //int i1 = Character.getNumericValue(dst);
                   //  System.out.println(i1);

                     // li:nth-child("+j+")>div>div.text-box>div.text-left>div.wrap>span.old-price
                    // li:nth-child("+j+")>div>div.text-box>div.text-left>div.wrap>span.price
                 }
                 else {
             System.out.println( "is not discount");
             //driver.findElement(By.cssSelector("div.paging>a.next.btn-blue")).click();

         }
             }

    }
}
