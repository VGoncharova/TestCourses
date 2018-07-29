package cources.pages;

import cources.elements.CheckBox;
import cources.elements.EditableTextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeliveryClubMainPageObject extends AbstractPage {
    private WebDriver driver;

    @FindBy(id = "user-addr__input")
    private WebElement addrInput;

    @FindBy(className = "user-addr__submit")
    private WebElement searchSubmitBtn;

    @FindBy(className = "authorization-btn--enter")
    private WebElement authBtn;

    @FindBy(xpath = "//li[@id='slick-slide00']//button")
    private WebElement btn00;

    @FindBy(xpath = "//li[@id='slick-slide01']//button")
    private WebElement btn01;

    @FindBy(xpath = "//li[@id='slick-slide02']//button")
    private WebElement btn02;

    @FindBy(xpath = "//li[@id='slick-slide03']//button")
    private WebElement btn03;

    @FindBy(xpath = "//li[@id='slick-slide04']//button")
    private WebElement btn04;

    @FindBy(xpath = "//button[@class='slick-next slick-arrow' and @aria-label=\"Next\"]")
    private WebElement btnBannerRight;

    @FindBy(xpath = "//button[@class='slick-prev slick-arrow' and @aria-label=\"Previous\"]")
    private WebElement btnBannerLeft;

    @FindBy(xpath = "//div[@class='slick-slide slick-current slick-active']/div[@class='dc-slide']")
    private WebElement activeBanner;

    private WebDriverWait waiter;

    private EditableTextField searchMealField;
    private CheckBox checkBoxPizza;

    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxListAll = new ArrayList<CheckBox>();

    @Override
    public void init(WebDriver webDriver) {
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        waiter = new WebDriverWait(driver, 20);
        PageFactory.initElements(webDriver, this);
    }

    public void gotoFoodEntity() {
        driver.get("https://www.delivery-club.ru/entities/food/?address=%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0%2C%20%D0%A8%D0%B0%D1%80%D0%B8%D0%BA%D0%BE%D0%BF%D0%BE%D0%B4%D1%88%D0%B8%D0%BF%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%B0%D1%8F%20%D1%83%D0%BB%D0%B8%D1%86%D0%B0%2C%2017&cat_id=1&district=&min_sum=5000&mo_mode=&mode=food&no_city=&okrug=&show=opened");

        List<WebElement> checkBoxes =
                driver.findElements(
                        By.xpath("//label[@class='vendors-filter__item']/input"));

        checkBoxes.clear();
        for (WebElement elem :
                checkBoxes) {
            CheckBox checkBox = new CheckBox(elem);
            checkBoxListAll.add(checkBox);
        }
    }

    public void checkSomeCheckBoxByName(String name) {
        for (CheckBox checkBox :
                checkBoxListAll) {
            if (checkBox.getName().equals(name)) {
                checkBox.check();
            }
        }
    }

    public void uncheckSomeCheckBoxByName(String name) {
        for (CheckBox checkBox :
                checkBoxListAll) {
            if (checkBox.getName().equals(name)) {
                checkBox.unCheck();
            }
        }
    }

    public String getActiveBannerImageUrl() {
        return activeBanner.getCssValue("background-image")
                .replaceAll("url\\(", "")
                .replaceAll("\\)", "");
    }

    public void clickArrowBannerButton(String direction) {
        if ("right".equals(direction)) {
            btnBannerRight.click();
        } else if ("left".equals(direction)) {
            btnBannerLeft.click();
        }
    }

    public void clickBannerBtnByNum(int num) {
        switch (num) {
            case 1:
                btn00.click();
                break;
            case 2:
                btn01.click();
                break;
            case 3:
                btn02.click();
                break;
            case 4:
                btn03.click();
                break;
            case 5:
                btn04.click();
                break;
        }
    }

    public void auth(String login, String password) {
        authBtn.click();

        EditableTextField loginField =
                new EditableTextField(driver.findElement(By.className("user-login__input")));
        loginField.appendText(login);

        //EditableTextField passField = new EditableTextField(driver.findElement(By.))
    }

    public CheckBox getCheckBoxNyName(String name) {
        for (CheckBox checkBox :
                checkBoxList) {
            if (checkBox.getName().equals(name)) {
                return checkBox;
            }
        }

        return null;
        //return checkBoxList.stream().filter(checkBox -> checkBox.getName().equals(name)).findFirst().get();
    }

    public void searchByAddr(String address) {
        fillAddrField(address);
        searchSubmitBtn.click();

        checkBoxPizza =
                new CheckBox(
                        waiter.until(
                                ExpectedConditions
                                        .presenceOfElementLocated(
                                                By.xpath("//input[./following-sibling::span[contains(.,'Пицца')]]")
                                        )
                        )
                );
    }

    public void clickSubmitBtn() {
        searchSubmitBtn.click();
    }

    public void fillAddrField(String address) {
        addrInput.sendKeys(address);
    }

    public void gotoMenu(String menuName) {
        WebElement menuLink =
                driver.findElement(By.linkText(menuName));

        if (menuLink != null) {
            menuLink.click();

            List<WebElement> checkBoxes =
                    driver.findElements(
                            By.xpath("//div[@class='vendors-filter__items-visible']/label/input"));

            checkBoxes.clear();
            for (WebElement elem :
                    checkBoxes) {
                CheckBox checkBox = new CheckBox(elem);
                checkBoxList.add(checkBox);
            }

            //checkBoxes.stream().map(elem -> new CheckBox(elem)).collect(Collectors.toList());
        }
    }

    public List<CheckBox> getCheckBoxList() {
        return checkBoxList;
    }

    public void gotoPizzaMenu() {
        WebElement pizzaMenuLink =
                driver.findElement(By.linkText("Пицца"));

        if (pizzaMenuLink != null) {
            pizzaMenuLink.click();

            searchMealField =
                    new EditableTextField(
                            waiter.until(
                                    ExpectedConditions
                                            .presenceOfElementLocated(
                                                    By.xpath("//input[@class='search-form__input input--def']")))
                    );
        }
    }

    public EditableTextField getSearchMealField() {
        return searchMealField;
    }

    public CheckBox getCheckBoxPizza() {
        return checkBoxPizza;
    }

    public int getCountRestaurants() {
        List<WebElement> checkBoxes =
                driver.findElements(By.xpath("//div[@class='vendor-list__container']/div/ul/li"));

        return checkBoxes == null ? 0 : checkBoxes.size();
    }
}
