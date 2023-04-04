package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://automationexercise.com/products";
    private final By searchInput = By.id("search_product");
    private final By submitSearch = By.id("submit_search");
    private final By itemNameField=By.xpath("//div[@class='features_items']/div[@class='col-sm-4']/div/div/div/p");


    @Step("First method")
    public void navigateUrl() {
        driver.navigate().to(url);
    }

    @Step("Second method")
    public void searchItem(String itemName) {
        driver.findElement(searchInput).sendKeys(itemName);
        driver.findElement(submitSearch).click();
    }
    @Step("Third method")
    public String[] getItems(){
        List<WebElement> itemList=driver.findElements(itemNameField);
        String[] itemNameList=new String[itemList.size()];
        int counter=0;
        for (WebElement item:itemList){
            itemNameList[counter]=item.getText();
            counter++;
        }
        return itemNameList;
    }

}
