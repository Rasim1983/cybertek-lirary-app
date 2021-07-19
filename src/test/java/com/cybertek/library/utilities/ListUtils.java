package com.cybertek.library.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {



    public static List<String> getTextOfElement(List<WebElement> list){
        List<String> elementsText = new ArrayList<>();
        for (WebElement elements : list) {
            elementsText.add(elements.getText());

        }
        return elementsText;
    }
}
