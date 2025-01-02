package com.didi.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {

    public MyJFrame3(){
        this.setSize(603, 680);

        this.setTitle("拼图单机版");
        // 设置页面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(null);

        // 给整个窗体添加键盘监听
        // this:当事件触发后会执行本类的代码
        this.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 细节1：如果按下一个按键没有松开，那么会重复调用keyPressed方法
    // 细节2：如何区分键盘上的不同按键
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        // 获取键盘上每一个按键的编号
        int code = e.getKeyCode();
//        System.out.println(code);
        if(code == 65){
            System.out.println("现在按的是A");
        } else if (code == 66){
            System.out.println("现在按的是B");
        }
    }
}
