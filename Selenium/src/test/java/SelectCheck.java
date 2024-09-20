import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {

    public boolean selectCheck(String abc, WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option: options){
            if( option.getText().equals(abc)){
                return true;
            }
        }
        return false;
    }
}
