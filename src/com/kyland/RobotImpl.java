package com.kyland;

import com.intellij.ide.ui.EditorOptionsTopHitProvider;
import sun.awt.ComponentFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.peer.RobotPeer;

/***
 *@Author: achen
 *@Date: ${time} ${date}
 *@Description:
 ***/
public class RobotImpl extends Robot  {

    RobotPeer peer = null;
    public RobotImpl() throws AWTException {
        GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        try {
            peer= ((ComponentFactory)toolkit).createRobot(this, screen);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void dispose()
    {
        peer.dispose();
    }

    public synchronized void keyPress(int keycode) {
        //checkKeycodeArgument(keycode);
        peer.keyPress(keycode);
    }

    public synchronized void keyRelease(int keycode) {
        checkKeycodeArgument(keycode);
        peer.keyRelease(keycode);
    }

    private void checkKeycodeArgument(int keycode) {
        // rather than build a big table or switch statement here, we'll
        // just check that the key isn't VK_UNDEFINED and assume that the
        // peer implementations will throw an exception for other bogus
        // values e.g. -1, 999999
        if (keycode == KeyEvent.VK_UNDEFINED) {
            throw new IllegalArgumentException("Invalid key code");
        }
    }
    //Shift组合键
    public void keyPressWithShift(int key){

        //按下Shift
        keyPress(KeyEvent.VK_SHIFT);
        //按下某个键
        keyPress(key);

        //释放某个键
        keyRelease(key);
        //释放Shift
        keyRelease(KeyEvent.VK_SHIFT);
        //等待100ms
        delay(100);
    }

    //Ctrl组合键
    public  void keyPressWithCtrl(int key){
        checkKeycodeArgument(key);
        keyPress(KeyEvent.VK_CONTROL);
        keyPress(key);

        keyRelease(key);
        keyRelease(KeyEvent.VK_CONTROL);

        delay(100);
    }

    //Alt组合键
    public  void keyPressWithAlt(int key){
        keyPress(KeyEvent.VK_ALT);
        keyPress(key);

        keyRelease(key);
        keyRelease(KeyEvent.VK_ALT);
        delay(100);
    }

    //输入字符串
    public void keyPressString(String str){
        //获取剪切板
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        //将传入字符串封装下
        Transferable tText = new StringSelection(str);
        //将字符串放入剪切板
        clip.setContents(tText, null);
        //按下Ctrl+V实现粘贴文本
        keyPressWithCtrl( KeyEvent.VK_V);
        delay(100);
    }

    //输入数字
    public  void keyPressNumber(int number){
        //将数字转成字符串
        String str = Integer.toString(number);
        //调用字符串的方法
        keyPressString(str);
    }

}
