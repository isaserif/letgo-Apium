package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import org.testng.asserts.SoftAssert;
import pages.LetgoPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class Stept_01 {
    LetgoPage letgoPage = new LetgoPage();
    TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
    SoftAssert softAssert =new SoftAssert();

    @Given("Uygulama acilir")
    public void uygulama_acilir() {
        Driver.getAppiumDriver();
        ReusableMethods.bekle(3);
    }

    @Given("{string} tiklar")
    public void tiklar(String str) {
        ReusableMethods.scrollWithUiScrollable(str);
    }

    @Given("{string} olarak {string} model olarak {string} secilir")
    public void olarak_model_olarak_secilir(String string, String string2, String string3) {
        ReusableMethods.scrollWithUiScrollable(string);
        ReusableMethods.scrollWithUiScrollable(string2);
        TouchAction touchAction;
        for (int i = 0; i < 18; i++) {
            touchAction = new TouchAction(Driver.getAppiumDriver())
                    .press(PointOption.point(179, 866))
                    .waitAction(waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(139, 259))
                    .release()
                    .perform();
        }
        ReusableMethods.scrollWithUiScrollable(string3);
    }

    @Given("Telefon {string} olarak {string} secilir")
    public void telefon_olarak_secilir(String renk, String type) {
        ReusableMethods.scrollWithUiScrollable(renk);
        TouchAction touchAction;
        for (int i = 0; i < 2; i++) {
            touchAction = new TouchAction(Driver.getAppiumDriver())
                    .press(PointOption.point(179, 866))
                    .waitAction(waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(139, 259))
                    .release()
                    .perform();
        }
        ReusableMethods.scrollWithUiScrollable(type);
        ReusableMethods.bekle(2);
    }

    @Given("Ilan basligi olarak {string} girilir")
    public void ilan_basligi_olarak_girilir(String string) {
        letgoPage.ilanBasligi.sendKeys(string);
        ReusableMethods.bekle(2);

    }

    @Given("Ne sattigini acikla kismina {string} girilir")
    public void ne_sattigini_acikla_kismina_girilir(String str) {
        letgoPage.neSattiginiAcikla.sendKeys(str);

    }
    @Given("Fotograf lari secer")
    public void fotograf_lari_secer() {
        ReusableMethods.bekle(3);
        touchAction.press(PointOption.point(198, 194))
                .waitAction(waitOptions(Duration.ofMillis(100)))
                .release()
                .perform();
        touchAction.press(PointOption.point(445, 196))
                .waitAction(waitOptions(Duration.ofMillis(100)))
                .release()
                .perform();


    }
    @Given("Fiya olarak {string} yazar")
    public void fiya_olarak_yazar(String string) {
        letgoPage.fiyat.sendKeys(string);
    }
    @Given("{string} yazisinin görüldügünü dogrular")
    public void yazisinin_görüldügünü_dogrular(String string) {

     String actualText=letgoPage.tebrikler.getText();
     softAssert.assertEquals(actualText,string);


    }
}
