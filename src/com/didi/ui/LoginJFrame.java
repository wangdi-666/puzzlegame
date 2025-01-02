package com.didi.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // 跟登录相关的代码，写在这个页面中

    // 写一个构造方法,在创建对象的时候给一些初始化
    public LoginJFrame(){
        this.setSize(488, 430);

        this.setTitle("拼图 登录");
        // 设置页面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(3);

        this.setVisible(true);
    }
}
