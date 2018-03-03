package com.kyland;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;
import java.awt.*;

/***
 * @author achen
 *
 */
public class TreeDemo extends AnAction {

    /***
     * MainMenu.demo点击事件
     * @param event
     */
    @Override
    public void actionPerformed(AnActionEvent event)
    {
       System.out.println("MainMenu clicked");
    }
}
