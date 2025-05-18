package org.example.utils;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DriverUtils {

    /**
     * Waiting for AJAX complete
     */
    public static void waitForAjax() {
        Wait().until(webDriver ->
                executeJavaScript("return jQuery.active == 0")
        );
    }

    public static void waitForPageLoad() {
        Wait().until(webDriver ->
                executeJavaScript("return document.readyState").equals("complete")
        );
    }

}
