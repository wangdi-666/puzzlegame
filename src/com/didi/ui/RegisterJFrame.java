package com.didi.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    // 跟注册相关的代码，写在这个页面中

    public RegisterJFrame(){
        this.setSize(488, 500);

        this.setTitle("拼图 注册");
        // 设置页面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(3);

        this.setVisible(true);
    }
}
