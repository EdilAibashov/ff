import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prctice {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "/Users/edilaibashov/IdeaProjects/Libraries/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(("http://practice.cybertekschool.com/"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='A/B Testing']")).click();
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[starts-with(.,'Add/Remove')]")).click();
        WebElement click = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0;i < 5;i++) {
            click.click();
        }
        Thread.sleep(1000);
        List<WebElement> delete = driver.findElements(By.className("added-manually"));
            for (WebElement d:delete){
                d.click();
            }
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.id("myCountryautocomplete-list")).click();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Basic Auth']")).click();
        Thread.sleep(2000);
        driver.get("http://admin:admin@practice.cybertekschool.com/basic_auth");
        String getMessage = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(getMessage);
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Broken Images']")).click();
        Thread.sleep(1000);
        List<WebElement> image = driver.findElements(By.tagName("img"));
        System.out.println("Images :"+image.size());
        Thread.sleep(1000);
        for (WebElement imga : image) {
            try {
                HttpURLConnection con = (HttpURLConnection) new URL(imga.getAttribute("src")).openConnection();
                con.setRequestMethod("GET");
                int resCode = con.getResponseCode();
                if (resCode != 200) {
                    System.out.println("Broken image :" + imga.getAttribute("src"));
                } else {
                    System.out.println("Fine Image :" + imga.getAttribute("src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[.='Checkboxes']")).click();
            List<WebElement> chk = driver.findElements(By.xpath("//input[@type='checkbox']"));
            for (WebElement c:chk){
                c.click();
            }
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='Disappearing Elements']")).click();
            driver.findElement(By.xpath("(//a[starts-with(@href,'/')])[2]")).click();
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='About']")).click();
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='Contact Us']")).click();
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='Portfolio']")).click();
            driver.navigate().back();
            driver.findElement(By.className("nav-link")).click();
            driver.findElement(By.xpath("//a[.='Drag and Drop']")).click();
            String BoxA ="column-a";
            WebElement box1 = driver.findElement(By.id(BoxA));
            String BoxB ="column-b";
            WebElement box2 = driver.findElement(By.id(BoxB));
            action.dragAndDrop(box1, box2).perform();
            driver.navigate().back();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[.='Dropdown']")).click();
            Select drop = new Select(driver.findElement(By.id("dropdown")));
            drop.selectByValue("1");
            Select year = new Select(driver.findElement(By.id("year")));
            year.selectByValue("1988");
            Select month = new Select(driver.findElement(By.id("month")));
            month.selectByValue("1");
            Select day = new Select(driver.findElement(By.id("day")));
            day.selectByValue("28");
            Select state = new Select(driver.findElement(By.id("state")));
            state.selectByValue("VA");
            Select languages = new Select(driver.findElement(By.name("Languages")));
            languages.selectByValue("java");
            driver.findElement(By.id("dropdownMenuLink")).click();
            driver.findElement(By.xpath("//a[.='Amazon']")).click();
            driver.navigate().back();
            driver.findElement(By.className("nav-link")).click();
            driver.findElement(By.xpath("//a[.='Dynamic Content']")).click();
            driver.navigate().refresh();
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='Dynamic Loading']")).click();
            driver.findElement(By.xpath("//a[.='Example 1: Element on page that is hidden and become visible after trigger']")).click();
            driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='Example 2: Element on the page that is rendered after the trigger']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            Thread.sleep(5000);
            System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
            Thread.sleep(1000);
            driver.navigate().back();
            driver.findElement(By.xpath("//a[.='Exit Intent")).click();



    }
}
