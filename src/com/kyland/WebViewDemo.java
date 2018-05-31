package com.kyland;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;

/***
 * @Author: achen
 * @Date:
 * @Description: Swing内嵌 Web View
 ***/
public class WebViewDemo {
    public static void main(String[] args) {
        JFXPanel jfxPanel = new JFXPanel();
        JFrame jFrame = new JFrame("JDos Browser");
        jFrame.add(jfxPanel);

// Creation of scene and future interactions with JFXPanel
// should take place on the JavaFX Application Thread
        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));
            webView.getEngine().load("http://www.stackoverflow.com/");
        });

        jFrame.show();
        jFrame.setSize(1000,800);
    }
}
